package com.huang.fight.game.domain;

/**
 * @auther: 宁哥
 * @date: 2019/3/27 15:21
 * @description: JSON响应数据结构
 */
public class FightResult
{
    /**
     * 响应业务状态
     */
    private Integer status;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应中的数据
     */
    private Object data;


    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }


    public FightResult(Object data,String msg)
    {
        this.status = 200;
        this.msg = msg;
        this.data = data;
    }


}
