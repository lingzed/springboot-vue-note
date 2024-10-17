# final修饰变量

> - 修饰的变量，初始化后值不可改变
> - 修饰局部变量，在使用前必须赋值才能使用
> - 修饰成员变量，若声明时没用赋值，则必须在构造方法或者static{}中实例化，静态变量在static{}中实例化，实例变量在构造方法中实例化(在{}中也可以)
> - 修饰基本类型，初始化后值不可改变
> - 修饰引用类型，引用地址不可改变，但对象中的成员可改变
> - 被final修饰变量也称常量，通常全字母大写，由多个字母组成用_分隔，如：STUDENT_NAME

1.

![image-20230904180326890](D:\text1\java_text\assets\image-20230904180326890.png)  

2.

![image-20230904180513766](D:\text1\java_text\assets\image-20230904180513766.png) 



# final修饰方法

> - final修饰的方法可以被重载
> - final修饰的方法可以被子类继承
> - final修饰的方法不能被子类重写

1.

![image-20230904181421470](D:\text1\java_text\assets\image-20230904181421470.png) 

2.

![image-20230904181926551](D:\text1\java_text\assets\image-20230904181926551.png) 



# final修饰类

> - final修饰的类，称为常量类，不能被继承
> - final类中的成员，可以用final修饰，也可不用final修饰
> - final类不能被继承，故类中所有方法自然不能被重写，方法自然也就成了final型。所以final中的变量和方法，都没必要再添加final修饰符

![image-20230904182629596](D:\text1\java_text\assets\image-20230904182629596.png) 



# final与abstract互斥

> - final与abstract互斥
> - 一个变量要么是final，表示它是一个不可变的常量，要么不是final，表示它是可变的
> - 一个方法要么是final，表示它是一个不可重写的方法，要么是abstract，表示它是抽象方法
> - 一个类要么是final，表示它是一个不可继承的最终类，要么是abstract，表示它是一个抽象类，不能被直接实例化