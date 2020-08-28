package demo.springboot.exception.handler.constant;

import lombok.Getter;

/**
 * <p>
 *     状态码
 * </p>
 */
@Getter
public enum Status {
    /**
     * 操作成功
     */
    OK(200, "操作成功"),

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(500, "服务器发生了一些错误");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
