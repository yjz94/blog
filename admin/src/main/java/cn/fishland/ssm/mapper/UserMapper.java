package cn.fishland.ssm.mapper;

import cn.fishland.ssm.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * TODO
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/19 7:59 下午
 */
public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

}
