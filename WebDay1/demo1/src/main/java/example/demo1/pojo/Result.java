package example.demo1.pojo;

public class Result {
    private Integer code; // 响应码，1 代表成功，0 代表失败
    private String msg;   // 响应信息，描述字符串
    private Object data;  // 返回的数据

    public Result() {
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 成功静态方法
    public static Result success() {
        return new Result(1, "操作成功", null);
    }

    // 成功静态方法（带数据）
    public static Result success(Object data) {
        return new Result(1, "操作成功", data);
    }

    // 成功静态方法（带消息和数据）
    public static Result success(String msg, Object data) {
        return new Result(1, msg, data);
    }

    // 失败静态方法
    public static Result error() {
        return new Result(0, "操作失败", null);
    }

    // 失败静态方法（带消息）
    public static Result error(String msg) {
        return new Result(0, msg, null);
    }

    // getter 和 setter 方法
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
