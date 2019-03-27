package com.huang.fight.game.domain;

import java.util.Random;

public abstract class Role
{
    /**
     * DEFAULT_BLOOD
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
