# 获取SqlSesion

```java
public class SqiSessionUtil{
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        try {
            // 加载核心配置文件也就是mybatis-config.xml，加载成字节输入流的形式
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // 获取SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            // 通过SqlSessionFactoryBuilder对象传入字节流来创建SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            // 获取SqlSession，默认手动提交，true表示自动提交
            sqlSession = sqlSessionFactory.openSession(true);
            return sqlSession;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
    
}
```

