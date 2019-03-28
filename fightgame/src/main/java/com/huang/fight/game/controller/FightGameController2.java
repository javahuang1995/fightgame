//package com.huang.fight.game.controller;
//
//import com.huang.fight.game.domain.FightResult;
//import com.huang.fight.game.domain.Robot;
//import com.huang.fight.game.domain.UserPlayer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Auther: 宁哥
// * @Date: 2019/3/27 20:51
// * @Description: session做一下隔离，但是并不是最好的办法。同一个浏览器开多个还是有问题的。
// */
//@Controller
//public class FightGameController2
//{
//
//
//    private static final Logger logger = LoggerFactory.getLogger(FightGameController2.class);
//
//
//    @RequestMapping(value = "/start/{hardLevel}", method = RequestMethod.GET)
//    public String startGame(@PathVariable("hardLevel") String hardLevel, HttpServletRequest request)
//    {
//        int attackLimit = 10;
//        if ("easy".equals(hardLevel))
//        {
//            attackLimit = 50;
//        }
//
//        request.getSession().setAttribute("userPlayer", new UserPlayer(attackLimit));
//        request.getSession().setAttribute("robot", new Robot());
//
//        //to game page
//        return "game";
//    }
//
//    @RequestMapping(value = "/attack", method = RequestMethod.GET)
//    public String attackRobot(Model model, HttpServletRequest request)
//    {
//
//        UserPlayer userPlayer = (UserPlayer) request.getSession().getAttribute("userPlayer");
//        Robot robot = (Robot) request.getSession().getAttribute("robot");
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
//            model.addAttribute("fightResult", displayBloodStatus(request));
//            return "kill";
//
//        }
//
//    }
//
//
//    @RequestMapping(value = "/displayStatus", method = RequestMethod.GET)
//    @ResponseBody
//    public FightResult displayBloodStatus(HttpServletRequest request)
//    {
//        UserPlayer userPlayer = (UserPlayer) request.getSession().getAttribute("userPlayer");
//        Robot robot = (Robot) request.getSession().getAttribute("robot");
//
//        Map hashMap = new HashMap(16);
//        hashMap.put("userPlayer blood", String.valueOf(userPlayer.getBlood()));
//        hashMap.put("robot blood", String.valueOf(robot.getBlood()));
//
//        return new FightResult(hashMap, "OK");
//
//    }
//}
