package cn.fishland.blog.service.impl;

import cn.fishland.blog.service.AuthService;
import cn.fishland.blog.util.FunctionUtil;
import org.springframework.stereotype.Service;

/**
 * 权限相关服务类实现
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/19 8:04 下午
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public boolean authentication(String key, String name, String password) {
        return FunctionUtil.auth(key, name, password);
    }

}
