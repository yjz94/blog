package cn.fishland.ssm.service.impl;

import cn.fishland.ssm.bean.User;
import cn.fishland.ssm.mapper.UserMapper;
import cn.fishland.ssm.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * TODO
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/19 8:04 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.findAll();
    }
}
