package com.github.winhandiao.runnables;

import com.github.winhandiao.PrimitiveTypeBytecode;

public class NonReverseNativeByteCodeRunnable implements Runnable{
    public byte[] bytes = new byte[10_000_000 * 8];
    @Override
    public void run() {
        long startTime = System.nanoTime();
        double d = 1.001;
        for (int i = 0; i < 10_000_000; i++) {
            for (byte b: PrimitiveTypeBytecode.getDoubleBytecode(d)) {
                bytes[i] = b;
                i++;
            }
            d *= 1.001;
        }
        System.out.println("[NonReverseNativeByteCodeRunnable] " + (System.nanoTime() - startTime));
    }
}
