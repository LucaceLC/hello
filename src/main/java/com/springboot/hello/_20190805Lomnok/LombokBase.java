package com.springboot.hello._20190805Lomnok;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class LombokBase {

    @Test
    @SneakyThrows({Exception.class})
    public void fucThorwsException(){
        int i = 1/0;
    }

    public static void main(String[] args) {
        LombokBase lombokBase = new LombokBase();
        lombokBase.fucThorwsException();
    }
}
