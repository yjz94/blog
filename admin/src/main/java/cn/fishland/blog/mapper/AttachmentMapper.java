package cn.fishland.blog.mapper;

import cn.fishland.blog.bean.Attachment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 附件数据库相关操作
 *
 * @author fishland
 * @version 1.0
 * @date 2021/12/1 10:50 下午
 */
public interface AttachmentMapper {

    @Insert("INSERT INTO attachment(`createDate`,`updateDate`,`status`,`contentType`,`file`,`aid`,`type`) " +
            "VALUES(#{createDate}, #{updateDate}, #{status}, #{contentType}, #{file}, #{aid}, #{type})")
    void insertAttachment(Attachment attachment);

    /**
     * 通过id获得附件信息
     *
     * @param id 附件id
     * @return 附件相关信息 Attachment
     */
    @Select("SELECT * FROM attachment WHERE `id` = #{id} and `status` = 1")
    Attachment getAttachmentById(Integer id);

    @Select("SELECT * FROM attachment")
    List<Attachment> getAttachmentAll();

    @Update("UPDATE attachment SET `updateDate` = #{updateDate},`status` = #{status},`contentType` = #{contentType}," +
            " `file` = #{file},`aid` = #{type},`type` = #{type} WHERE `id` = #{id}")
    void updateAttachment(Attachment attachment);

    @Delete("DELETE FROM attachment WHERE `id` = #{id}")
    void deleteAttachment(Integer id);
}
