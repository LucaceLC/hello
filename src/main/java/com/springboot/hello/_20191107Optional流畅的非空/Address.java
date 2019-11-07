package com.springboot.hello._20191107Optional流畅的非空;

import lombok.Data;

import java.util.Optional;

@Data
public class Address {
    private String userAddress;

    public Optional<String> getUserAddress() {
        return Optional.ofNullable(userAddress);
    }}
