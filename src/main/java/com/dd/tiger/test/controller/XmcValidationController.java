package com.dd.tiger.test.controller;

import com.dd.tiger.test.dto.Login;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("v")
@RestController
public class XmcValidationController {


    /**
     *  Validation How To
     *
     1. Set http header Content-Type: application/json
     2. Add body
     // post payload :
     {"name":"myname","nickname":"NMKJPQWZXIC","password":"Length greater than 16."}

     then

     // post payload :
     {"name":"myname","nickname":"LENGTH_GREATER_THAN_20_NMKJPQWZXIC","password":"Length greater than 16."}

     * @param login     Login Object from request body
     * @return
     */
    @PostMapping("login")
    public Login login(@Valid @RequestBody Login login){
        System.out.printf("Login valid for [MethodArgumentNotValidException:password] and [ConstraintViolationException:nickname]");
        System.out.println(LocaleContextHolder.getLocale());
        return login;
    }
}
