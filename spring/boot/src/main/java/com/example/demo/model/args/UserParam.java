package com.example.demo.model.args;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class UserParam implements Serializable {
    @NotBlank(message = "姓名不能为空")
    private String name;

    private Long id;
}
