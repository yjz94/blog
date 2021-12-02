package cn.fishland.blog.bean;

/**
 * 文章附件实体类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/21 11:25 下午
 */
public class Attachment extends BaseBean {

    private String contentType;
    private String file;
    private Integer aid;
    private String type;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "contentType='" + contentType + '\'' +
                ", file='" + file + '\'' +
                ", aid=" + aid +
                ", type=" + type +
                ", id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", status=" + status +
                '}';
    }
}
