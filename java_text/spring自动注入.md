# byName

> byName注入的原理：
>
> 有BookDaoImpl和BookServiceImpl两个实现类，BookServiceImpl实现类中有bookDaoImpl属性，需要将BookDaoImpl实例注入到bookDaoImpl属性中。

![image-20230902144035042](D:\text1\java_text\assets\image-20230902144035042.png) 

> 使用byName自动注入，原理是这样的：
>
> 首先在测试类中，获取xml配置文件对象，再获取BookServiceImpl对应id的\<bean>实例。

![image-20230902144312754](D:\text1\java_text\assets\image-20230902144312754.png) 

> 之后，spring容器会自动到该类中查找，此处是到com.lwn.Dao.impl包下的BookDaoImpl中，然后查找BookDaoImpl中的引用类型的属性。

![image-20230902144629132](D:\text1\java_text\assets\image-20230902144629132.png) 

> BookServiceImpl的引用类型只有一个就是bookDaoImpl，那么spring容器就会根据这个属性的名称在xml中匹配id与之对应的\<bean>

![image-20230902144931161](D:\text1\java_text\assets\image-20230902144931161.png) 

> 找到了与属性名一致的id，此处是bookDaoImpl这个\<bean>，然后会获取这个类的类型，这个类是com.lwn.Dao.impl.BookDaoImpl，那么类型就是BookDaoImpl类型，接着会将BookServiceImpl中的bookDaoImpl属性的类型与该类型比较，如果相同，则将BookDaoImpl的实例注入到bookDaoImpl属性中，如果不相同则不注入。

![image-20230902145522363](D:\text1\java_text\assets\image-20230902145522363.png) 

![image-20230902150121731](D:\text1\java_text\assets\image-20230902150121731.png) 

> 运行：

![image-20230902150949564](D:\text1\java_text\assets\image-20230902150949564.png) 

> **总结：**获取xml中id对应的\<bean>，进入该\<bean>映射的类中拿到引用类型的属性，回到xml中，查找有无id与拿到的属性名一致的\<bean>，有就继续判断该\<bean>映射的类的类型是否与拿到的属性类型一致，如果一致则注入，否则不注入，如果未找到id与拿到的属性名一致的\<bean>则也不注入。
>
> **注意：**需要保证要注入的实例其\<bean>的id必须与被注入的属性名一致，且属性名的类型必须与注入的实例类型一致。



# byType

> byType注入思路是这样的：
>
> 跟byName一样，到id对应的\<bean>的映射类中，查找引用类型的属性，获取这些属性的类型，此处的类型是BookDaoImpl。

![image-20230902162246191](D:\text1\java_text\assets\image-20230902162246191.png) 

> 然后在xml中匹配class是这个类型的\<bean>，匹配成功后将这个\<bean>的实例注入到bookDaoImpl中，匹配失败则不注入。此时这个\<bean>不要求定义id或name。 

![image-20230902162819218](D:\text1\java_text\assets\image-20230902162819218.png) 

> 被注入的属性的类型，可以与注入这个属性的实例的类型相同，也可以是注入这个属性的实例的类型的父类。注入到bookDaoImpl的实例其类型是BookDaoImpl，也就是说bookDaoImpl的类型可以是BookDaoImpl也可以是BookDao，但必须保证set方法中的形参类型是注入这个属性的实例的类型。

![image-20230902163551935](D:\text1\java_text\assets\image-20230902163551935.png) 

> 另外，使用byType时，必须保证只有一个\<bean>的class是注入到属性的实例类型，如果多个则报错。

![image-20230902164009717](D:\text1\java_text\assets\image-20230902164009717.png) 

# constructor

> 通过constructor构造方法注入，与byType类似，是在xml中匹配与构造方法中的形参类型相同的类型的\<bean>，如果能匹配就将这个\<bean>的实例注入到构造方法中，由构造方法实例化属性，如果匹配不到就注入失败。

![image-20230902165724130](D:\text1\java_text\assets\image-20230902165724130.png) 

> 也可以使用id来匹配，在xml中匹配id与构造方法中形参名相同的\<bean>，如果能匹配就将这个\<bean>的实例注入到构造方法中，由构造方法实例化属性，如果匹配不到就注入失败。

![image-20230902165851000](D:\text1\java_text\assets\image-20230902165851000.png) 

> 此时可以声明多个相同类型的\<bean>，只需要id不同即可。

![image-20230902170106178](D:\text1\java_text\assets\image-20230902170106178.png) 