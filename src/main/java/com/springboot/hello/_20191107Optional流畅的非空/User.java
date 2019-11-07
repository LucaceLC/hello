package com.springboot.hello._20191107Optional流畅的非空;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

@Data
@Accessors(chain = true)
public class User {

    private Address address;

    private Money moneyNumber;

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }
    private String name;
    private String email;



}
