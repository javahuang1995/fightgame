package com.huang.fight.game.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FightGameControllerTest
{
    @Autowired
    private FightGameController fightGameController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(fightGameController).build();
    }


    @Test
    public void startGame() throws Exception
    {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/start/easy")).andReturn();
        Assert.assertTrue("game".equals(mvcResult.getResponse().getForwardedUrl()));
        Assert.assertTrue(200 == mvcResult.getResponse().getStatus());
    }

    @Test
    public void attackRobot() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/start/easy"));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/attack")).andReturn();
        Assert.assertTrue(200 == mvcResult.getResponse().getStatus());
        Assert.assertTrue("kill".equals(mvcResult.getResponse().getForwardedUrl()));
    }

    @Test
    public void displayBloodStatus() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/start/easy"));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/status")).andReturn();
        Assert.assertTrue(200 == mvcResult.getResponse().getStatus());
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据=====:" + result);
    }

}