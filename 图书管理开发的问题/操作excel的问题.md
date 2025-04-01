# 读-version1

这个是第一版本的读操作。首先读取excel文件，读取器需要文件名、实体类、监听器：

```java
void readExcel() {
    String fileName = "C:\\Users\\asus\\Desktop\\1234.xlsx";
    EasyExcel.read(fileName, Book.class, readListener)
        .sheet()
        .doRead();
}
```

实体类的作用是将读取的数据封装在里面，监听器则是监听读取的情况来执行相应的操作，它是easy excel提供的接口：ReadListener。

```java
public class BookReadListener implements ReadListener<Book> {
    private static final Integer MAX_SIZE = 3;
    private List<Book> books = new ArrayList<>(MAX_SIZE);

    @Autowired
    private BookService bookService;


    /**
     * 读取回调，每读取一行，执行一次
     *
     * @param book
     * @param analysisContext
     */
    @Override
    public void invoke(Book book, AnalysisContext analysisContext) {
        books.add(book);
        if (books.size() == MAX_SIZE) {
            log.info("booklist：{}", books);
            log.info("执行存储操作");
            saveData();
        }
    }

    /**
     * 数据读取完后执行
     *
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("数据读取完毕");
        log.info("booklist：{}", books);
        if (books.size() > 0) {
            log.info("执行存储操作");
            saveData();
        }
    }

    //    @Transactional
    public void saveData() {
        bookService.addBooks(books);
        books.clear(); // 清空list
    }
}
```

其中有两个方法invoke和doAfterAllAnalysed

- invoke是读取回调，每读取一行数据，就执行一次
- doAfterAllAnalysed是数据读取完成后执行

版本1的思路是，用一个有限容量的List去缓存每次读取的数据，当List容量满后，就存库，清空List，直到数据读取完成，在doAfterAllAnalysed中再次处理没有存储完的数据。之所以用有限容量的List是为了避免一次性将数据全部存入List导致内存负担。

这个版本存在一个问题，假设，excel的数据有5行，按照上面的流程，前3次读取数据会将文件的前3行存入List中，然后去执行一次存库操作，接着再读取数据存入List中，List最后只有2行数据，故List的长度为2，就不会执行存库操作。数据读取完毕后执行doAfterAllAnalysed方法，在该方法中检查到List中还有数据，就执行一次存库操作。

整个流程中，一共执行了两次存库操作。如果第1次存库操作成功，第2次的存库操作，因数据有误程序报错，那么第2次的数据就无法存入数据库，这就导致数据不一致。根本原因是这两次操作不在一次原子性操作中。

可以给这两个方法开启事务，但是经我测试，不管怎么加事务都不能很好的解决问题，反而还会导致其他问题。



# 读-version2

第2版本中，舍弃了List作为缓存，改为每读取一行数据就执行一次存库操作。每读取一行数据就立即处理和保存，这样可以及时释放内存，并在读取过程中减少内存占用。而且这样做还能在invoke完成所有的存款操作，方面进行事务，避免数据不一致性。

```java
public void invoke(Book book, AnalysisContext analysisContext) {
    /* 如果出现中间有空的情况，easyexcel会为每个属性赋予默认值，默认值为数据类型对应的默认值
     *  遇到这种情况需要跳过，该空行，直接读取下一行
     * */
    if (book.getIsbn() == null) {
        if (book.isEmptyRow()) return;
    }
    log.info("book：{}", book);
    log.info("执行存储操作");
    bookService.addBook(book);
    log.info("{}", ++i);
}

/**
 * 数据读取完后执行
 *
 * @param analysisContext
 */
@Override
public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    i = 0;
    log.info("数据读取完毕");
}
```

考虑到excel中有空行的存在，所以这里对空行进行了处理，如果是空行直接结束方法，相当于跳过空行。isEmptyRow在实体类中定义的就是判断为空行的情况。为空行时，EasyExcel会自动将数据处理成属性类型的默认值，应用类型为null，基本数据类型为其默认值。由于我的所以属性都是引用类型，所以以null来判断：

```java
public Boolean isEmptyRow() {
    return isbn == null && name == null &&
            cover == null && author == null &&
            publish == null && publishDate == null &&
            bookTypeId == null && description == null &&
            number == null;
}
```

这种方式也有问题，就是处理大数据量的文件时对数据库的消耗较大。



# 读-version3

最终还是回到第一种方法，处理大数据量的时候，应该用一个缓存列表存储存储一部分数据再执行存库操作，避免每读取一次，就执行一次存库操作，减少访问数据库频率从而减少数据库的开销。接下来就是解决事务的问题。在invoke和doAfterAllAnalysed中开启事务，但是这两个事务是独立的。还是那个问题，5条数据，第4条有问题，前三条数据存库后事务就提交了，后两条数据存库报错，事务回滚但是回滚的是这次的，第一轮的3条数据提交操作没有回滚。根本原因就是因为这两次事务不在一个事务内。怎么办呢？既然不在一个事务内就想办法把他们加入到一个事务中去，这就要用的事务的传播行为了。默认情况下事务的传播性是REQUIRED，表示如果当前有事务，那么新开启的事务就会加入到当前事务中去，否则就开启新的事务。细品这句话，发现在invoke和doAfterAllAnalysed开启事务之前是没有事务的，如果我们在invoke和doAfterAllAnalysed开启事务之前开启了一个事务，那么invoke和doAfterAllAnalysed的事务就会加入到当前的这个事务中，进而nvoke和doAfterAllAnalysed的事务就是同一个事务了。如何加呢？很简单，invoke和doAfterAllAnalysed是监听器中的方法，谁调用监听器，谁就同时调用了nvoke和doAfterAllAnalysed，那么只需要让它开启事务即可。

导入excel的控制器调用监听器，因此在它上面添加事务：

```java
@PostMapping
@Transactional
public Result importExcel(MultipartFile excelFile) throws IOException {
    InputStream inputStream = excelFile.getInputStream();
    EasyExcel.read(inputStream, Book.class, readListener).sheet().doRead();
    return Result.success();
}
```

nvoke和doAfterAllAnalysed操作存库的方式是调用service层的存库业务，也就是说他们都会调用service层的添加方法，而且还是同一个方法，既然如此我可以直接在添加方法上开启事务，就不用在nvoke和doAfterAllAnalysed上都开启事务了：

```java
// 添加book的方法，开启事务，nvoke和doAfterAllAnalysed都调用该方法
@Transactional
@Override
public void addBooks(List<Book> books) {
    LocalDateTime now = LocalDateTime.now();
    for (Book book : books) {
        book.setUpdateTime(now);
        book.setCreateTime(now);
        System.out.println("service执行" + book);
    }
    bookMapper.addBooks(books);
}
```

最终的监听器：

```java
@Component
public class BookReadListener implements ReadListener<Book> {
    // 缓存列表存储book
    private List<Book> bookBuffer = new ArrayList<>();
    // 定义list的最大容量
    private Integer maxSize = 3;
    @Resource
    private BookService bookService;

    @Override
    public void invoke(Book book, AnalysisContext analysisContext) {
        // 如果有空行跳过
        if (book.getIsbn() == null) {
            if (book.isEmptyRow()) return;
        }
        bookBuffer.add(book);
        // 如果list装满了执行存库操作
        if (bookBuffer.size() == maxSize) save();
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 最后一轮读取完成后，如果list中还有book，存库
        if (!bookBuffer.isEmpty()) save();
    }

    public void save() {
        // 执行存入book操作
        bookService.addBooks(bookBuffer);
        // 清空book
        bookBuffer.clear();
    }
}
```

这套操作，事务的流程如下：

1、创建了事务，是由导入excel的控制器创建的：

![image-20240622003626162](assets\image-20240622003626162.png)

2、第一轮读取完毕，调用addBooks开启事务，此时由于导入excel的控制器创建了事务，所以新事务会参与到当前事务中：

![image-20240622003834895](assets\image-20240622003834895.png)

然后执行存库操作，存库操作成功，如果后续没有事务，那么整个事务提交，如果后续有事务，等待后续的事务完成。

3、第二轮读完完毕，调用addBooks开启事务，此时由于导入excel的控制器创建了事务，所以新事务也会参与到当前事务中：

![image-20240622004149086](assets\image-20240622004149086.png)

执行存库操作，操作报错，整个大的事务回滚，报告第一轮的事务：

![image-20240622004324903](assets\image-20240622004324903.png)



# 关于excel的日期类型

在excel中日期是以数字的形式存在的，表示从1900-01-01到当前日期的天数，比如日期2024-06-18在excel中的日期数字为45461，这两个日期实际的天数差是45459，在excel中反而多出了2天，因为excel的日期计算时错误的认为某两年是闰年，因此才会多出2天。所以实际天数应该是excel中的日期天数-2。
