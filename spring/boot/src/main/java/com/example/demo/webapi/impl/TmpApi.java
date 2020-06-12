package com.example.demo.webapi.impl;

import com.example.demo.common.IsIdCardNo;
import com.example.demo.model.args.UserParam;
import com.example.demo.model.request.Request;
import com.example.demo.wrapper.RequestWrapper;
import com.example.demo.wrapper.ResponseWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Api(tags = "用户管理")
@RestController
public class TmpApi {
    @RequestMapping("/hi1")
    public ResponseWrapper<String> hi1(@Valid @RequestBody TmpParam2 args) {
        return new ResponseWrapper<>("hi1");
    }

    @RequestMapping("/hi2")
    public ResponseWrapper<String> hi2(@Valid @RequestBody Request<@Valid TmpParam2> args) {
        return new ResponseWrapper<>("hi2");
    }

    @RequestMapping("/hi3")
    public ResponseWrapper<String> hi3(@Valid @RequestBody TmpParam args) {
        return new ResponseWrapper<>("hi3");
    }
}

@Data
class TmpParam {
    @Size(min = 10, max = 20, message = "min value is 10,max value is 20.")
    @NotBlank(message = "val can not be null.")
    private String val;

    @Valid
    TmpParam2 p2;
}

@Data
class TmpParam2 {
    @Size(min = 10, max = 20, message = "min value is 10,max value is 20.")
    @NotBlank(message = "val can not be null.")
    private String val2;
}