package com.xipengyuan.demo.instrument.app;

public class Launcher {

    public static void main(String[] args) throws InterruptedException {
        if (args[0].equals("StartMyAtmApplication")) {
            new MyAtmApplication().run(args);
        } else if (args[0].equals("LoadAgent")) {
            new AgentLoader().run(args);
        }
    }
}
