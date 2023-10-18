package com.xipengyuan.demo.instrument.app;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyAtmApplication {

    public void run(String[] args) throws InterruptedException {
        log.info("[Application] Starting ATM application");

        MyAtm.withdrawMoney(Integer.parseInt(args[2]));
        Thread.sleep(Long.parseLong(args[1]));
        MyAtm.withdrawMoney(Integer.parseInt(args[3]));
    }
}
