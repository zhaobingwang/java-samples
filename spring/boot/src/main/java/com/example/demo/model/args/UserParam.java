package com.example.demo.model.args;

import com.example.demo.common.IsIdCardNo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@ApiModel(value = "查询用户信息参数对象")
@Data
public class UserParam implements Serializable {

    @Size(min = 10, max = 20, message = "min value is 10,max value is 20.")
    @ApiModelProperty(value = "用户姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(value = "身份证号码")
    @IsIdCardNo
    private String idCardNo;

    private Long id;
}
