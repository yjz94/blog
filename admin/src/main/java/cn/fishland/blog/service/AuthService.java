package cn.fishland.blog.service;

/**
 * 权限相关服务
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/19 8:09 下午
 */
public interface AuthService {

    /**
     * 检测登录是否合法
     *
     * @param key      计算的key
     * @param name     用户名
     * @param password 密码
     * @return 是否成功
     */
    boolean authentication(String key, String name, String password);

}
