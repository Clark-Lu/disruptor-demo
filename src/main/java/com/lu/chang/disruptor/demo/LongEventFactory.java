package com.lu.chang.disruptor.demo;

import com.lmax.disruptor.EventFactory;

/**
 * created by LuChang
 * 2019/3/5 16:02
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
