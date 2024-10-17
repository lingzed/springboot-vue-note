DownLoadUtil是下载工具类，详情见"19.springboot文件下载/1.下载.md"

下载excel功能，一开始的实现是创建一个字节数组输出流，然后EasyExcel将内容写入到输出流中，然后再将输出流转换成数组，然后调用下载工具类传入数组进行下载：

```java
List<Book> books = bookService.queryBookByIds(null);
// 创建字节数组输出流
ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
// EasyExcel将内容写入到字节数组输出流中
EasyExcel.write(byteArrayOutputStream, Book.class).sheet("sheet1").doWrite(books);
// 将字节数组输出流转换成字节数组
byte[] bytes = byteArrayOutputStream.toByteArray();
// 调用工具类下载
DownLoadUtil.doDownload(resp, bytes, exportFileName);
```

但其实EasyExcel能将内容写入到字节数组输出流中，那么代表它能将内容写入到流中，而响应流也是一个流，因此EasyExcel能直接将内容写入到响应流中，就不用将内容写入到字节数组中再进行下载了：

```java
// 因此我尝试直接将内容写入到响应流中
// 设置下载的响应头
...
response.setContentlenghtLong()
```

到设置响应体的长度时出现问题了，文件的大小如何设置呢？我们是将内容直接写入到响应流中，如何知道文件的大小？流是没法获取文件的大小的。要么我们将流中的内容写入到字节数组，要么将流的内容写入到文件。所以这种实现只能pass掉了。

回到第一种实现方法，这种方法是一次性将所有数据写入到数组中，我们假设books的数据量非常大有几十万条数据，如果我们一次性将所有数据写入到数组中会造成内存负担，甚至会报内存溢出异常。

为了避免这种情况发生，我们可以将内容写入到一个临时文件中，然后将文件的内容写入到响应流最后删除临时文件。这种方式对内存的消耗较小：

```java
// 创建临时文件的File对象
File tempFile = File.createTempFile("template", "xlsx");
// 将内容写入到临时文件中
EasyExcel.write(tempFile, Book.class).sheet("sheet1").doWrite(books);
// 调用工具类
DownloadUtil.doDownload(response, tempFile, "书本信息")
```

DownloadUtil中针对大文件的下载进行了缓存下载处理：

```java
public static void doDownLoad(HttpServletResponse resp, File file, String filename) throws IOException {
    setResponse(resp, file.length(), filename);
    try (FileInputStream fis = new FileInputStream(file); ServletOutputStream os = resp.getOutputStream()) {
        byte[] buffer = new byte[1024]; // 创建一个缓存数组
        int byteRead;
        /*
         * 从输入流中读取数据时，缓冲区buffer被填充。
         * 由于读取的字节数可能小于缓冲区的大小，因此需要知道实际读取的字节数bytesRead。
         * 这确保了只写入有效的字节数而不是整个缓冲区。
         * */
        while ((byteRead = fis.read(buffer)) != -1) { // 数组装满或读取完成后执行
            // 0，这是写入的起始偏移量，表示从缓冲区的第一个字节开始写入。
            // bytesRead，这是实际读取的字节数，表示从缓冲区中写入到输出流的字节数。
            os.write(buffer, 0, byteRead);
        }
    }
}
```

下载完成后要删除缓存文件：

```java
// 创建临时文件的File对象
File tempFile = File.createTempFile("template", "xlsx");
// 将内容写入到临时文件中
EasyExcel.write(tempFile, Book.class).sheet("sheet1").doWrite(books);
// 调用工具类
DownloadUtil.doDownload(response, tempFile, "书本信息");
// 删除临时文件
template.delete()
```

