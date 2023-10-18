package com.xipengyuan.demo.instrument.app;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyAtm {

    public static void withdrawMoney(int amount) throws InterruptedException {
        Thread.sleep(2000L);
        log.info("[Application] Successful Withdrawal of [{}] units!", amount);
    }
}
