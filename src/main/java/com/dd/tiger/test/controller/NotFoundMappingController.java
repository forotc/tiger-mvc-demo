package com.dd.tiger.test.controller;

import com.dd.xmc.web.R;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 重写错误控制器，替代spring boot 默认的白板页面.
 */
@Controller
public class NotFoundMappingController implements ErrorController {

    public String getErrorPath(){
        return "/error";
    }

    @ResponseBody
    @RequestMapping("/error")
    public Object error(HttpServletRequest request){
        return R.output(404,"not found");
    }
}
