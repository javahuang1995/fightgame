package com.huang.fight.game.controller;

import com.huang.fight.game.domain.FightResult;
import com.huang.fight.game.domain.Robot;
import com.huang.fight.game.domain.UserPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 宁哥
 * @date: 2019/3/27 13:51
 * @description: 对象存在成员变量中，多线程下是不安全的。
 */
@Controller
@Scope(value = "session")
public class FightGameController
{
    /**
     * 默认攻击值
     */
    private static final Integer DEFAULT_ATTACK = 10;

    /**
     * 充值玩家攻击值
     */
    private static final Integer HIGHER_ATTACK = 50;

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FightGameController.class);

    private Robot robot = null;

    private UserPlayer userPlayer = null;




    /**
     * @param hardLevel 难度级别
     * @return String
     */
    @RequestMapping(value = "/start/{hardLevel}", method = RequestMethod.GET)
    public String startGame(@PathVariable("hardLevel") String hardLevel)
    {
        robot = new Robot();
        userPlayer = new UserPlayer(DEFAULT_ATTACK);
        if ("easy".equals(hardLevel))
        {
            userPlayer.setAttackLimit(HIGHER_ATTACK);
        }
        //to start page
        return "start";
    }

    /**
     * 攻击机器人
     * @return String
     */
    @RequestMapping(value = "/attackRobot", method = RequestMethod.GET)
    public String attackRobot(Model model)
    {
        if (userPlayer == null || robot == null)
        {
            return "redirect:/index.html";
        }

        if (robot.getBlood() <= 0 || userPlayer.getBlood() <= 0)
        {
            if (userPlayer.getBlood() > robot.getBlood())
            {
                LOGGER.info("gameOver,you win.");
                model.addAttribute("fightResult", "you win.");
            }
            else
            {
                LOGGER.info("gameOver,you failed.");
                model.addAttribute("fightResult", "you failed.");
            }
            return "gameOver";
        }
        else
        {
            //attack
            userPlayer.attack(robot);
            //fight back
            robot.attack(userPlayer);
            LOGGER.info("kill robot", "user blood:", userPlayer.getBlood(), "robot blood:", robot.getBlood());
            model.addAttribute("fightResult", displayBloodStatus());
            return "attack";

        }

    }


    /**
     * 显示玩家和机器人状态
     * @return FightResult
     */
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @ResponseBody
    public FightResult displayBloodStatus()
    {
        if (userPlayer == null || robot == null)
        {
            return new FightResult(null, "FAIL");
        }

        Map hashMap = new HashMap(16);
        hashMap.put("userPlayer blood", String.valueOf(userPlayer.getBlood()));
        hashMap.put("robot blood", String.valueOf(robot.getBlood()));

        return new FightResult(hashMap, "OK");

    }


}
