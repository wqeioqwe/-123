package com.example.app.module.index.controller;


import com.example.app.currency.ResultData;
import com.example.app.module.index.entity.IndexInformation;
import com.example.app.module.index.entity.SystemTest;
import com.example.app.module.index.server.SystemTestServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags="用户模块操作接口",consumes="application/json", produces="application/json", protocols="http, https, ws, wss")
@RestController
public class IndexController {

    @Resource
    private SystemTestServer systemTestServer;

    @ApiOperation(value = "接口说明",httpMethod = "GET",notes = "测试接口")
    @RequestMapping(value = "/indexDemo",method= RequestMethod.GET)
    public ResultData<List<SystemTest>> index(String name){

        return systemTestServer.getTask(name);

    }

    @RequestMapping(value = "/cg",method=RequestMethod.GET)
    public List<IndexInformation> indexTest(String l){

        return systemTestServer.cg(l);

    }

    @RequestMapping(value = "/lop",method=RequestMethod.GET)
    public List<IndexInformation> indexLop(String l){

        return systemTestServer.cg(l);

    }

    @RequestMapping("/")
    public String index(HttpServletResponse response) throws Exception {

        response.sendRedirect("/public/homePage");
        return "register";

    }


}
