package cn.fishland.ssm;

import cn.fishland.ssm.bean.User;
import cn.fishland.ssm.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * TODO
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/19 8:28 下午
 */
public class Test {

    public static void main(String[] args) throws IOException {
        Logger logger = LoggerFactory.getLogger(Test.class);
        logger.info("asas");
        InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = userMapper.findAll();

        System.out.println(all);
    }
}
