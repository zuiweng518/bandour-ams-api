package com.ams.api.controller;

import com.alibaba.fastjson.JSON;
import com.ams.api.entity.App;
import com.ams.api.entity.RoleOrgs;
import com.ams.api.service.AppService;
import com.ams.api.service.RoleOrgsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ams")
public class IndexController {
    private static Logger log= LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private AppService appService;
    @Autowired
    private RoleOrgsService roleService;
    @RequestMapping("/getOrgRoleByAccount")
    @ResponseBody()
    public String index(HttpServletRequest request){
        String domains = request.getHeader("X-Forwarded-For");
        String app_code=request.getHeader("app_code");
        String app_secret=request.getHeader("app_secret");
        String account=request.getParameter("account");
        App app=appService.findApp(app_code,app_secret,domains);
        String json="";
        List<RoleOrgs> list=new ArrayList<RoleOrgs>();

        if(app!=null){
            list=roleService.findRoleOrgsByAccount(account);
            json=JSON.toJSONString(list);
            json="{\"content\":"+json+",\"error\":null}";
            System.out.println(json);
        }else{
            json="{\"content\":\"\",\"error\":\"请检查app_code和app_secret\"}";

        }
        return json;
    }
}
