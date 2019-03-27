package com.huang.fight.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @Auther: 宁哥
 * @Date: 2019/3/27 12:25
 * @Description:
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(Application.class);
    }


    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
