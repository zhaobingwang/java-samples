package com.example.demo.exception;

import com.alibaba.fastjson.JSON;
import com.example.demo.constants.ApiCode;
import com.example.demo.wrapper.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseWrapper handleException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return new ResponseWrapper(ApiCode.SYS_INTERNAL_SERVER_ERROR,
                ApiCode.SYS_INTERNAL_SERVER_ERROR_MESSAGE);

    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper handleException(BusinessException ex) {
        logger.error(ex.getMessage(), ex);
        return new ResponseWrapper(ex.getCode(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseWrapper handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        ex.getBindingResult()
                .getAllErrors()
                .forEach((error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
//                    errors.put(fieldName, errorMessage);
                    sb.append("[" + fieldName + ":" + errorMessage + "]");
                });

        return new ResponseWrapper(ApiCode.FAIL,
                sb.toString());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(BindException.class)
    public ResponseWrapper handleValidationExceptions2(BindException ex) {
        Map<String, String> errors = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        ex.getBindingResult()
                .getAllErrors()
                .forEach((error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
//                    errors.put(fieldName, errorMessage);
                    sb.append("[" + fieldName + ":" + errorMessage + "]");
                });

        return new ResponseWrapper(ApiCode.FAIL,
                sb.toString());
    }
}
