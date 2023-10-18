package com.xipengyuan.demo.instrument.agent;

import lombok.extern.slf4j.Slf4j;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

@Slf4j
public class MyInstrumentationAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        log.info("[Agent] In premain method");
        String className = "com.xipengyuan.demo.instrument.app.MyAtm";
        transformClass(className, inst);
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        log.info("[Agent] In agentmain method");
        String className = "com.xipengyuan.demo.instrument.app.MyAtm";
        transformClass(className, inst);
    }

    private static void transformClass(String className, Instrumentation instrumentation) {
        Class<?> targetCls;
        ClassLoader targetClassLoader;
        // 使用当前类加载器查找指定名称的类
        try {
            targetCls = Class.forName(className);
            targetClassLoader = targetCls.getClassLoader();
            transform(targetCls, targetClassLoader, instrumentation);
        } catch (ClassNotFoundException e) {
            log.error("Class {} not found with Class.forName", className, e);
        }
        // 否则，从所有已加载的类中查找我们想要的
        for (Class<?> clazz : instrumentation.getAllLoadedClasses()) {
            if (clazz.getName().equals(className)) {
                targetCls = clazz;
                targetClassLoader = targetCls.getClassLoader();
                transform(targetCls, targetClassLoader, instrumentation);
                return;
            }
        }

        throw new RuntimeException("Failed to find class " + className);
    }

    private static void transform(Class<?> clazz, ClassLoader classLoader, Instrumentation instrumentation) {
        var dt = new AtmTransformer(clazz.getName(), classLoader);
        instrumentation.addTransformer(dt, true);
        try {
            instrumentation.retransformClasses(clazz);
        } catch (UnmodifiableClassException e) {
            throw new RuntimeException("Transform failed for class: " + clazz.getName(), e);
        }
    }
}
