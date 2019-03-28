package com.huang.fight.game.domain;


import org.springframework.stereotype.Component;

/**
 * @Auther: 宁哥
 * @Date: 2019/3/27 12:08
 * @Description:
 */
@Component
public class UserPlayer extends Role
{
    private int attackLimit;

    public UserPlayer(){
        super();
    }

    public UserPlayer(int limit)
    {
       super();
       this.attackLimit = limit;
    }

    public int getAttackLimit()
    {
        return attackLimit;
    }

    public void setAttackLimit(int attackLimit)
    {
        this.attackLimit = attackLimit;
    }

    @Override
    public void attack(Role role)
    {
        int kill = UserPlayer.RANDOM.nextInt(attackLimit);
        role.setBlood(role.getBlood() - kill);
    }
}
