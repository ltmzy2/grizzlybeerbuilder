package com.jy.x.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-14 16:28
 **/
@Slf4j
@Component
public class CommandRunner implements CommandLineRunner {

    @Value("${spring.web.loginurl}")
    private String address;

    @Value("${spring.web.googleexcute}")
    private String googleExcutePath;

    @Value("${spring.auto.openurl}")
    private boolean isOpen;

    @Override
    public void run(String... args) {
        if (isOpen) {
            String cmd = googleExcutePath + " " + address;
            Runtime run = Runtime.getRuntime();
            try {
                run.exec(cmd);
                log.debug("chrome打开项目成功~");
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
    }
}
