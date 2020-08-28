package demo.springboot.exception.handler.exception;

import demo.springboot.exception.handler.constant.Status;
import lombok.Getter;

/**
 * <p>
 * Json异常
 * </p>
 */
@Getter
public class JsonException extends BaseException {
    public JsonException(Status status) {
        super(status);
    }

    public JsonException(Integer code, String message) {
        super(code, message);
    }
}
