package com.example.demo.controller.viewmodel;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
public class UserViewModel {
    private Long id;
    private String name;
    private String password;
    private String email;
    private String identityId;
    private String regTime;
}
