package com.huang.fight.game.domain;

import org.springframework.stereotype.Component;

/**
 * @auther: huagngning
 * @date: 2019/3/27 12:12
 * @description: 机器人
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
