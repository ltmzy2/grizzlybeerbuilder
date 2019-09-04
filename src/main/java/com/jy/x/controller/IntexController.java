package com.jy.x.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-13 17:11
 **/
@Slf4j
@Controller
public class IntexController {

    @GetMapping(value = "/")
    public String index() {
        log.info("index..........");
        return "index";
    }

}
