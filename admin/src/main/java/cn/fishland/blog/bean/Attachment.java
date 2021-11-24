package cn.fishland.blog.bean;

import java.sql.Blob;

/**
 * 文章附件实体类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/21 11:25 下午
 */
public class Attachment extends BaseBean {

    private String contentType;
    private Blob file;
    private Integer aid;
    private Integer type;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
