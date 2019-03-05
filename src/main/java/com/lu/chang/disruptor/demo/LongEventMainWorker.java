package com.lu.chang.disruptor.demo;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;

/**
 * created by LuChang
 * 2019/3/5 16:43
 */
public class LongEventMainWorker {


    public static void main(String[] args) throws Exception {
        // The factory for the event
        LongEventFactory factory = new LongEventFactory();

        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 1024;

        // Construct the Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, bufferSize, DaemonThreadFactory.INSTANCE);

        // Connect the handler
        disruptor.handleEventsWithWorkerPool(new LongEventWorker(),new LongEventWorker());

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducerWithTranslator producer = new LongEventProducerWithTranslator(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 1; true; l++)
        {
            bb.putLong(0, l);
            producer.onData(bb);
            if (l%10 == 0) {
                Thread.sleep(1000);
            }
        }
    }

}
