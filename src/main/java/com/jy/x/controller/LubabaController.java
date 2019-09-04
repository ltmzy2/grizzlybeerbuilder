package com.jy.x.controller;

import com.jy.x.service.GenerateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-05 11:23
 **/
@Slf4j
@RestController
public class LubabaController {

    @Autowired
    GenerateService generateService;

    /**
     * 生成lubabaservice
     *
     * @param entityName
     * @param response
     * @return void
     * @author: Jy  2019/8/12 11:42
     */
    @GetMapping("/genService/{entityName}")
    public synchronized void genService(@PathVariable(value = "entityName", required = true) String entityName, HttpServletResponse response) {
        log.info("genService.........");
        if (StringUtils.isEmpty(entityName)) {
            return;
        }
        generateService.download(response, generateService.genService(entityName));
    }

}
