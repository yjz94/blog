package cn.fishland.blog.service.impl;

import cn.fishland.blog.bean.Attachment;
import cn.fishland.blog.bean.pojo.Message;
import cn.fishland.blog.mapper.AttachmentMapper;
import cn.fishland.blog.service.AttachmentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

/**
 * 附件服务类实现类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/12/1 8:24 下午
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

    Logger log = Logger.getLogger(AttachmentServiceImpl.class);

    @Autowired
    AttachmentMapper attachmentMapper;

    @Override
    public Message attachmentAdd(MultipartFile file, String path, String fileName) {
        try {
            File attachmentPath = new File(path);
            if (!attachmentPath.exists()) {
                attachmentPath.mkdir();
            }
            String filePath = path + File.separator + fileName;
            file.transferTo(new File(filePath));

            Attachment attachment = new Attachment();
            attachment.setAid(0);
            attachment.setStatus(1);
            attachment.setUpdateDate(new Date(System.currentTimeMillis()));
            attachment.setCreateDate(new Date(System.currentTimeMillis()));
            attachment.setFile(filePath);
            attachment.setContentType(file.getContentType());
            attachment.setType(fileName.substring(fileName.lastIndexOf(".") + 1));

            attachmentMapper.insertAttachment(attachment);

            log.info(String.format("保存后的附件信息=[%s]", attachment.toString()));

            return new Message("添加附件成功！");
        } catch (IOException e) {
            e.printStackTrace();
            return new Message("attachment to file error");
        }
    }

    @Override
    public ResponseEntity<byte[]> getAttachment(Integer id) {
        try {
            Attachment attachment = attachmentMapper.getAttachmentById(id);
            //获取服务器中文件的真实路径
            String filePath = attachment.getFile();
            // 创建输入流
            InputStream is = new FileInputStream(filePath);
            //创建字节数组
            byte[] bytes = new byte[is.available()];
            // 将流读到字节数组中
            is.read(bytes);
            //创建HttpHeaders对象设置响应头信息
            MultiValueMap<String, String> headers = new HttpHeaders();
            //设置附件为下载
            //headers.add("Content-Disposition", "attachment;filename=1.jpg");
            //设置附件为直接显示
            headers.add("Content-Type", attachment.getContentType());
            //设置响应状态码
            HttpStatus statusCode = HttpStatus.OK;
            //创建ResponseEntity对象
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
            //关闭输入流
            is.close();
            return responseEntity;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Attachment> getAllAttachment() {
        return attachmentMapper.getAttachmentAll();
    }

    @Override
    public Message attachmentUpdate(MultipartFile file, String path, String fileName, String oldFileName, Integer id) {

        try {
            // 获得附件信息
            Attachment attachment = attachmentMapper.getAttachmentById(id);
            if (attachment == null || attachment.getId() == null) {
                return new Message("附件信息查询不到");
            }

            // 删除附件文件
            File fileObj = new File(oldFileName);
            if (fileObj.isFile() && fileObj.exists()) {
                fileObj.delete();
            }

            // 插入新文件
            File attachmentPath = new File(path);
            if (!attachmentPath.exists()) {
                attachmentPath.mkdir();
            }
            String filePath = path + File.separator + fileName;
            file.transferTo(new File(filePath));

            // 更新附件内容
            attachment.setUpdateDate(new Date(System.currentTimeMillis()));
            attachment.setContentType(file.getContentType());
            attachment.setFile(filePath);

            attachmentMapper.updateAttachment(attachment);

            return new Message("更新附件成功");
        } catch (IOException e) {
            e.printStackTrace();
            return new Message("更新附件失败");
        }
    }

    @Override
    public Message attachmentDelete(Integer id) {
        try {
            // 删除本地文件
            Attachment attachment = attachmentMapper.getAttachmentById(id);
            File file = new File(attachment.getFile());
            if (file.exists() && file.isFile()) {
                file.delete();
            }

            attachmentMapper.deleteAttachment(id);
            return new Message("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("删除文件失败");
        }
    }

}
