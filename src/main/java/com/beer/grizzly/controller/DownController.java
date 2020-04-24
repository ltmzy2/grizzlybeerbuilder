package com.beer.grizzly.controller;

import com.beer.grizzly.service.GenerateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class DownController {

    @Autowired
    GenerateService generateService;

    @GetMapping("/downCode/{fileName}")
    public String downCode(HttpServletResponse response, @PathVariable(value = "fileName", required = true) String fileName) {
        log.info("用户请求下载{}",fileName);
        try {
            generateService.download(response, fileName);
        }catch (Exception e){
            e.printStackTrace();
            return "未找到指定文件!";
        }
        return "success";
    }
}
