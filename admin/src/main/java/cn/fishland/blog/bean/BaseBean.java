package cn.fishland.blog.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

/**
 * bean类基础类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/21 11:11 下午
 */
public abstract class BaseBean {

    protected Integer id;
    protected Date createDate;
    protected Date updateDate;
    protected Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
