package com.xipengyuan.demo.instrument.app;

import com.sun.tools.attach.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Slf4j
public class AgentLoader {

    public void run(String[] args) {
        String agentFilePath = "/home/adi/Desktop/agent-1.0.0-jar-with-dependencies.jar";
        final String applicationName = "MyAtmApplication";

        // 遍历所有JVM，找到匹配我们应用名的那台
        Optional<String> jvmProcessOpt = VirtualMachine.list().stream()
                .filter(vmDesc -> {
                    log.info("VM: {}", vmDesc.displayName());
                    return vmDesc.displayName().contains(applicationName);
                })
                .map(VirtualMachineDescriptor::id)
                .findFirst();

        if (jvmProcessOpt.isEmpty()) {
            log.warn("未找到指定的应用：{}", applicationName);
            return;
        }

        File agentFile = new File(agentFilePath);
        String jvmPid = jvmProcessOpt.get();
        log.info("Attaching to target JVM with PID: " + jvmPid);

        try {
            VirtualMachine jvm = VirtualMachine.attach(jvmPid);
            jvm.loadAgent(agentFile.getAbsolutePath());
            jvm.detach();
            log.info("Attached to target JVM and loaded Java agent successfully");
        } catch (AttachNotSupportedException | AgentLoadException | AgentInitializationException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
