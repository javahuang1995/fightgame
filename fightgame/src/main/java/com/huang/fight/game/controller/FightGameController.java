//package com.huang.fight.game.controller;
//
//import com.huang.fight.game.domain.FightResult;
//import com.huang.fight.game.domain.Robot;
//import com.huang.fight.game.domain.UserPlayer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author: 宁哥
// * @date: 2019/3/27 13:51
// * @description:使用Prototype也是没有意义
// */
//@Controller
////@Scope(value = "prototype")
//public class FightGameController
//{
//    private static Robot robot = new Robot();
//    private static UserPlayer userPlayer = new UserPlayer();
//
//    private static final Logger logger = LoggerFactory.getLogger(FightGameController.class);
//
////    @RequestMapping("/index")
////    public String hello()
////    {
////        return "index";
////    }
////
//
//    @RequestMapping(value = "/start/{hardLevel}", method = RequestMethod.GET)
//    public String startGame(@PathVariable("hardLevel") String hardLevel)
//    {
//        int attackLimit = 10;
//        if ("easy".equals(hardLevel))
//        {
//            attackLimit = 50;
//        }
//        userPlayer.setAttackLimit(attackLimit);
//
//        //to game page
//        return "game";
//    }
//
//    @RequestMapping(value = "/attack", method = RequestMethod.GET)
//    public String attackRobot(Model model)
//    {
//        if (robot.getBlood() <= 0 || userPlayer.getBlood() <= 0)
//        {
//            if (userPlayer.getBlood() > robot.getBlood())
//            {
//                logger.info("gameOver,you win.");
//                model.addAttribute("fightResult", "you win.");
//            }
//            else
//            {
//                logger.info("gameOver,you failed.");
//                model.addAttribute("fightResult", "you failed.");
//            }
//            return "gameOver";
//        }
//        else
//        {
//            //attack
//            userPlayer.attack(robot);
//            //fight back
//            robot.attack(userPlayer);
//            logger.info("kill robot", "user blood:", userPlayer.getBlood(), "robot blood:", robot.getBlood());
//            model.addAttribute("fightResult", displayBloodStatus());
//            return "kill";
//
//        }
//
//    }
//
//
//    @RequestMapping(value = "/displayStatus", method = RequestMethod.GET)
//    @ResponseBody
//    public FightResult displayBloodStatus()
//    {
//        Map hashMap = new HashMap(16);
//        hashMap.put("userPlayer blood", String.valueOf(userPlayer.getBlood()));
//        hashMap.put("robot blood", String.valueOf(robot.getBlood()));
//
//        return new FightResult(hashMap, "OK");
//
//    }
//
//
//}
