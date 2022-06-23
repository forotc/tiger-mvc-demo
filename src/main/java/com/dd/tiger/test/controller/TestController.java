package com.dd.tiger.test.controller;

import com.dd.xmc.exception.BizException;
import com.dd.xmc.web.param.U;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("t")
@RestController
public class TestController {
    @RequestMapping("g")
    public Map<String,String> getVal(){
        Map map = new HashMap();
        map.put("a", "aa");
        map.put("b", 1);

        return map;
    }

    @RequestMapping("t")
    public Map<String,String> testException(){
        int x = 3;
        if(x%3 ==0)
            throw new BizException(9999);
        return null;
    }


    @RequestMapping("u")
    public Map<String,String> testException(U u){

        Map map = new HashMap();
        if (u.getId() != null) {
            map.put("uid",u.getId());
        }else{
            map.put("uid","unknown");
        }
        return map;
    }
}
