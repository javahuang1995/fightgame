package com.huang.fight.game.domain;

import java.util.Random;

/**
 * @auther: 宁哥
 * @date: 2019/3/27 12:12
 * @description: Role角色抽象类
 */
public abstract class Role
{
    /**
     * 默认血量
     */
    private static int DEFAULT_BLOOD = 100;

    /**
     * random
     */
    protected static Random RANDOM = new Random();


    /**
     * blood
     */
    private int blood;


    public Role()
    {
        this.blood = DEFAULT_BLOOD;
    }

    public Role(int blood)
    {
        this.blood = blood;
    }

    public int getBlood()
    {
        return blood;
    }

    public void setBlood(int blood)
    {
        this.blood = blood;
    }

    abstract public void attack(Role role);
}
