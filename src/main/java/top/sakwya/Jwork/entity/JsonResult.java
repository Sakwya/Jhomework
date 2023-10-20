package top.sakwya.Jwork.entity;

/**
 * 统一返回对象
 *
 * @param <T>
 * @author Sakwya
 */
public class JsonResult<T>{
    private T data;
    private final String msg;

    public JsonResult() {
        this.msg = "操作成功！";
    }

    public JsonResult(String msg) {
        this.msg = msg;
    }

    public JsonResult(T data) {
        this.data = data;
        this.msg = "操作成功！";
    }

    public JsonResult(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
