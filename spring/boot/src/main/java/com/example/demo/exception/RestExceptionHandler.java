package com.example.demo.exception;

import com.example.demo.wrapper.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

//    @ExceptionHandler(value = NotFoundException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseWrapper handleResourceNotFoundException(NotFoundException e) {
//        logger.error(e.getMessage(), e);
//        return new ResponseWrapper(String.valueOf(e.getCode()), e.getMessage(), "0", null);
//    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseWrapper handleException(Exception e) {
        logger.error(e.getMessage(), e);
        if (e instanceof BusinessException) {
            BusinessException be = (BusinessException) e;
            return new ResponseWrapper(0, be.getMessage(), be.getCode(), null);
        } else {
            return new ResponseWrapper(0, "服务器发生了未知的错误", "0", null);
        }
    }
}
