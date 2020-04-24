package com.beer.grizzly.controller;

import com.beer.grizzly.entity.ReqPara;
import com.beer.grizzly.entity.Vo;
import com.beer.grizzly.utils.SqlParseUtil;
import com.beer.grizzly.service.GenerateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class GenerateController {

    @Autowired
    GenerateService generateService;

    //生成通用文件
    @PostMapping("/genCode")
    public synchronized Vo genCode(@RequestBody Map<String,String> map) {
        log.info("genCode.......");
        ReqPara reqPara = new ReqPara();
        reqPara.setPackageName(map.get("packageName"));
        reqPara.setSql(map.get("sql"));
        List<Map<String, Object>> list = SqlParseUtil.parseSql(reqPara.getSql());
        String fileName = generateService.genService(list, reqPara);
        return new Vo("200","success",fileName);
    }

}
