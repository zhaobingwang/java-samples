package com.example.demo.model.args;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(value = "查询用户信息参数对象")
@Data
public class UserParam implements Serializable {

    @ApiModelProperty(value = "用户姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    private Long id;
}
