package cn.fishland.ssm.service;

import cn.fishland.ssm.bean.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * TODO
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/19 8:09 下午
 */
public interface UserService {

    List<User> findAll() throws IOException;
}
