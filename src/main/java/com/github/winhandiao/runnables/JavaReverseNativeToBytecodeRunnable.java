package com.github.winhandiao.runnables;

import com.github.winhandiao.PrimitiveTypeBytecode;

import java.util.Arrays;

public class JavaReverseNativeToBytecodeRunnable implements Runnable{
    public byte[] bytes = new byte[10_000_000 * 8];
    @Override
    public void run() {
        long startTime = System.nanoTime();
        double d = 1.001;
        for (int i = 0; i < 10_000_000; i++) {
            i += 8;
            for (byte b: PrimitiveTypeBytecode.getDoubleBytecode(d)) {
                i--;
                bytes[i] = b;
            }
            i += 8;
            d *= 1.001;
        }
        System.out.println("[JavaReverseNativeToBytecodeRunnable] " + (System.nanoTime() - startTime));
    }

}
