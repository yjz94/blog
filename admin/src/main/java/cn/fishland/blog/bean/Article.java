package cn.fishland.blog.bean;

/**
 * 文章实体类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/21 11:19 下午
 */
public class Article extends BaseBean {

    private String title;
    private String text;
    private String content;
    private Integer up;
    private Integer read;
    private Integer down;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", content='" + content + '\'' +
                ", up=" + up +
                ", read=" + read +
                ", down=" + down +
                ", id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", status=" + status +
                '}';
    }
}
