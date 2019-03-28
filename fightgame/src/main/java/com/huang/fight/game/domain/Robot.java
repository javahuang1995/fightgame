package com.huang.fight.game.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Auther: 宁哥
 * @Date: 2019/3/27 12:12
 * @Description:
 */
@Component
public class Robot extends Role
{

    public Robot()
    {
        super();
    }

    @Override
    public void attack(Role role)
    {
        int kill = RANDOM.nextInt(10);
        role.setBlood(role.getBlood() - kill);
    }
}
