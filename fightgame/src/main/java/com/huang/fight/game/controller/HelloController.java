package com.huang.fight.game.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{

    @RequestMapping("/hello")
    @ResponseBody
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name)
    {
        return "hello," + name;
    }
}