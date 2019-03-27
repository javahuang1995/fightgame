package com.huang.fight.game;

import com.huang.fight.game.domain.Robot;
import com.huang.fight.game.domain.Role;
import com.huang.fight.game.domain.UserPlayer;

/**
 * @Auther: 宁哥
 * @Date: 2019/3/27 12:04
 * @Description:
 */
public class MainApp
{
    public static void main(String[] args)
    {
        Role robot = new Robot();
        Role userplayer = new UserPlayer(3);

        robot.attack(userplayer);
        userplayer.attack(robot);

        System.out.println(robot.getBlood());
        System.out.println(userplayer.getBlood());
    }
}
