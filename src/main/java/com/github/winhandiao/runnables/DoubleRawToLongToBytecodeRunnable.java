package com.github.winhandiao.runnables;

import com.github.winhandiao.PrimitiveTypeBytecode;

public class DoubleRawToLongToBytecodeRunnable implements Runnable{
    public byte[] bytes = new byte[10_000_000 * 8];
    @Override
    public void run() {
        long startTime = System.nanoTime();
        double d = 1.001;
        for (int i = 0; i < 10_000_000; i++) {
            for (byte b: longToBytes(Double.doubleToRawLongBits(d))) {
                bytes[i] = b;
                i++;
            }
            d *= 1.001;
        }
        System.out.println("[DoubleRawToLongToBytecodeRunnable] " + (System.nanoTime() - startTime));
    }

    /* https://stackoverflow.com/questions/4485128/how-do-i-convert-long-to-byte-and-back-in-java */
    public static byte[] longToBytes(long l) {
        byte[] result = new byte[Long.BYTES];
        for (int i = Long.BYTES - 1; i >= 0; i--) {
            result[i] = (byte)(l & 0xFF);
            l >>= Byte.SIZE;
        }
        return result;
    }}
