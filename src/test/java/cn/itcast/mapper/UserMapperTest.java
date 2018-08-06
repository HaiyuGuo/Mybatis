package cn.itcast.mapper;

import cn.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserMapperTest {

    // 1 定义一个userMapper成员变量, 方便其他成员方法调用
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        // 2 初始化 userMapper
        // 2.1 生成SqlSessionFactory 对象, 作用: 加载外部的配置文件 和 生成sqlsession对象
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 2.2 生成sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 2.3 生成userMapper的实现类
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void queryUserById() throws Exception {
        User user = userMapper.queryUserById(2L);
        System.out.println(user);
    }

    @Test
    public void queryAll() throws Exception {
        List<User> userList = userMapper.queryAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() throws Exception {
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }
    
    @Test
    public void demo1() {
        //  如何通过类找到类的全路径
        Class<UserMapper> clazz = UserMapper.class;
        String clazzName = clazz.getName();
        System.out.println(clazzName);
    }

}