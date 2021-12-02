package cn.fishland.blog.controller;

import cn.fishland.blog.bean.Attachment;
import cn.fishland.blog.bean.pojo.Message;
import cn.fishland.blog.service.AttachmentService;
import cn.fishland.blog.util.FunctionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 附件控制类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/12/1 6:41 下午
 */
@RestController
@RequestMapping("/admin")
public class AttachmentController {

    Logger log = Logger.getLogger(AttachmentController.class);

    @Autowired
    AttachmentService attachmentService;

    @GetMapping("/attachment/{id}")
    public ResponseEntity<byte[]> attachmentGet(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            return null;
        }
        return attachmentService.getAttachment(id);
    }

    @GetMapping("/attachment")
    public List<Attachment> attachmentGetAll() {
        return attachmentService.getAllAttachment();
    }

    @PostMapping("/attachment")
    public Message attachmentAdd(MultipartFile file, String _method, String oldFileName, HttpSession session) {
        try {
            //获取上传的文件的文件名
            String fileName = file.getOriginalFilename();
            //获得文件后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 判断是否为图片
            if (!FunctionUtil.isImag(suffixName.substring(1))) {
                return new Message("请上传规定文件");
            }
            fileName = FunctionUtil.uuid() + suffixName;

            //获取服务器中photo目录的路径
            ServletContext servletContext = session.getServletContext();
            String path = servletContext.getRealPath("attachment");

            return attachmentService.attachmentAdd(file, path, fileName);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(String.format("add attachment error=[%s]", e.getMessage()));
            return new Message("添加附件失败，请重试");
        }
    }

    @DeleteMapping("/attachment")
    public Message attachmentUpdate(Integer id) {
        try {
            return attachmentService.attachmentDelete(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(String.format("add attachment error=[%s]", e.getMessage()));
            return new Message("删除附件失败，请重试");
        }
    }

}
