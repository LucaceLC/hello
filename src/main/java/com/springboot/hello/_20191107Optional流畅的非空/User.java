package com.springboot.hello._20191107Optional流畅的非空;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private String name;
    private String email;
}
