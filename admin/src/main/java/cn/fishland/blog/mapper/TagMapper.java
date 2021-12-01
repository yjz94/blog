package cn.fishland.blog.mapper;

import cn.fishland.blog.bean.Tag;
import cn.fishland.blog.bean.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 标签相关数据库操作
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/28 6:43 下午
 */
public interface TagMapper {

    @Insert("INSERT INTO type(`name`,`status`,`createDate`,`updateDate`,`type`) " +
            "VALUES(#{name},#{status},#{createDate},#{updateDate},#{type})")
    void addTag(Tag tag);

    @Select("SELECT * FROM type WHERE name = #{name} and `type` = 2")
    Type getByName(String name);

    @Select("SELECT * FROM type WHERE `type` = 2")
    List<Type> getAll();

    @Select("SELECT * FROM type WHERE `status` = 1 AND `type` = 2")
    List<Type> getByStatus();

    @Select("SELECT * FROM type WHERE `type` = 2 ORDER BY `id` ASC LIMIT #{page},#{rows}")
    List<Type> getAllByPage(@Param("page") Integer page, @Param("rows") Integer rows);

    @Update("UPDATE type set `name` = #{name}, `status` = #{status}, `updateDate` = #{updateDate} WHERE id = #{id} ")
    void update(Tag tag);

    @Delete("DELETE FROM type WHERE id = #{id}")
    void deleteById(Integer id);

    @Select("SELECT COUNT(1) FROM type WHERE `id` = #{id}")
    Integer exist(Integer id);

    @Select("SELECT COUNT(1) FROM type WHERE `name` = #{name} AND `type` = 2")
    Integer existName(String name);

    @Select("SELECT count(1) FROM type WHERE `type` = 2")
    Integer countType();

}
