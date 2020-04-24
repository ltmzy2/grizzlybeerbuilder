package com.beer.grizzly.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IntexController {

    @GetMapping(value = "/")
    public String index() {
        log.info("index..........");
        return "index";
    }

}
