package top.zpliu.cloud.common.constant;

public enum ApiResultCode {

    SUCCESS("0000","操作成功"),
    INTERNAL_SERVER_ERROR("9999","未知异常"),
    ;

    private String code;

    private String message;

    ApiResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
