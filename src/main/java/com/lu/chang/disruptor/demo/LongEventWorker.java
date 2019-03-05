package com.lu.chang.disruptor.demo;

import com.lmax.disruptor.WorkHandler;

/**
 * created by LuChang
 * 2019/3/5 16:42
 */
public class LongEventWorker implements WorkHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event) throws Exception {
        System.out.println(Thread.currentThread().getName() + ":" + event.getValue());
    }
}
