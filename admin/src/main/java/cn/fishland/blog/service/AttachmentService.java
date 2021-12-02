package cn.fishland.blog.service;

import cn.fishland.blog.bean.Attachment;
import cn.fishland.blog.bean.pojo.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 附件服务类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/12/1 8:21 下午
 */
public interface AttachmentService {

    /**
     * 将内容保存在本地，并把信息存在数据库
     *
     * @param file     文件内容
     * @param path     文件文件夹路径
     * @param fileName 文件名称
     * @return 处理情况
     */
    Message attachmentAdd(MultipartFile file, String path, String fileName);

    ResponseEntity<byte[]> getAttachment(Integer id);

    List<Attachment> getAllAttachment();

    Message attachmentUpdate(MultipartFile file, String path, String fileName, String oldFileName, Integer id);

    Message attachmentDelete(Integer id);
}
