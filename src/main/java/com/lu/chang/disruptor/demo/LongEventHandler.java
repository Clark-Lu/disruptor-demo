package com.lu.chang.disruptor.demo;


import com.lmax.disruptor.EventHandler;

/**
 * created by LuChang
 * 2019/3/5 16:03
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(Thread.currentThread().getName() + ":" + longEvent.getValue());
    }
}
