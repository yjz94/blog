package cn.fishland.blog.bean;

/**
 * 文章标签实体类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/21 11:26 下午
 */
public class Tag extends BaseBean {

    private String name;
    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
