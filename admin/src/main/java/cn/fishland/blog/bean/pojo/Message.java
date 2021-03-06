package cn.fishland.blog.bean.pojo;

/**
 * 用于前端相应数据
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/24 9:37 下午
 */
public class Message {

    private String message;
    private Integer error;
    private Object data;

    public Message() {
    }

    public Message(String message) {
        this.error = 0;
        this.message = message;
    }

    public Message(String message, Integer error) {
        this.message = message;
        this.error = error;
    }

    public Message(Object data) {
        this.error = 0;
        this.message = "success";
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", error=" + error +
                '}';
    }
}
