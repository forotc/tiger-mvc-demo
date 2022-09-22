package com.dd.tiger.test.controller;

import com.dd.xmc.exception.BizException;
import com.dd.xmc.web.R;
import com.dd.xmc.web.param.U;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("t")
@RestController
public class XmcDemoController {

    /**
     * Wrap to R object.
     * @return
     */
    @RequestMapping("g")
    public Map<String,String> getVal(){
        Map map = new HashMap();
        map.put("a", "aa");
        map.put("b", 1);
        return map;
    }

    /**
     * Return R object directly.
     * @return
     */
    @RequestMapping("r")
    public R getValTypeR(){
        Map map = new HashMap();
        map.put("a", "aa");
        map.put("b", 1);
        map.put("r", LocalDateTime.now());

        return R.ok(map);
    }

    /**
     * business exception
     * @return
     */
    @RequestMapping("be")
    public Map<String,String> testBaseException(){

        Map map = new HashMap();
        map.put("a", "aa");
        map.put("b", 1);
        map.put("c", "exception");

        int x = map.size();
        if(x%3 == 0)
            throw new BizException(7000);
        return map;
    }


    /**
     * other exceptions handle
     * @return
     */
    @RequestMapping("e")
    public Map<String,String> testException(){

        Map map = new HashMap();
        map.put("method","testException");

        int x = 3/(map.size()-1);

        return map;
    }


    /**
     * Param user auto-injection.
     * @param u
     * @return
     */

    @RequestMapping("u")
    public Map<String,String> testResolver(U u){

        Map map = new HashMap();
        if (u.getId() != null) {
            map.put("uid",u.getId());
        }else{
            map.put("uid","unknown");
        }
        return map;
    }
}
