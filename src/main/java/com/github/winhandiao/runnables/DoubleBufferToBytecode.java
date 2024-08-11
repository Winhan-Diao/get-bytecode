package com.github.winhandiao.runnables;

import com.github.winhandiao.PrimitiveTypeBytecode;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class DoubleBufferToBytecode implements Runnable{

    public byte[] bytes = new byte[10_000_000 * 8];
    @Override
    public void run() {
        long startTime = System.nanoTime();
        double d = 1.001;
        for (int i = 0; i < 10_000_000; i++) {
            for (byte b: ByteBuffer.allocate(8).putDouble(d).array()) {
                bytes[i] = b;
                i++;
            }
            d *= 1.001;
        }
        System.out.println("[DoubleBufferToBytecode] " + (System.nanoTime() - startTime));
    }
}
