package com.github.winhandiao;

import com.github.winhandiao.runnables.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new PureNativeToBytecodeRunnable());
        Thread t2 = new Thread(new NonReverseNativeByteCodeRunnable());
//        Thread t3 = new Thread(new JavaReverseNativeToBytecodeRunnable());
//        Thread t4 = new Thread(new DoubleRawToLongToBytecodeRunnable());
        Thread t5 = new Thread(new DoubleBufferToBytecode());

        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
        t5.start();

        t1.join();
        t2.join();
//        t3.join();
//        t4.join();
        t5.join();

        Thread.sleep(1000);

    }

    public static void $(String str) {
        for (byte b: ClassTypeBytecode.getInstanceBytecode(str, false)) {
            System.out.print(Integer.toHexString(b & 0xFF) + " ");
//            System.out.print((char)b + " ");
        }
        System.out.println();
    }
}

/*
        System.out.println("Hello world!");

                System.out.println("2: " + PrimitiveTypeBytecode.getIntBitCast(2));

                System.out.println(Long.toHexString(Double.doubleToRawLongBits(0.0/0.0)).toUpperCase());
                System.out.println("2.1d: " + Long.toHexString(PrimitiveTypeBytecode.getDoubleBitCast(0.0/0.0)).toUpperCase());
                System.out.println("2.1d: " + Long.toHexString(PrimitiveTypeBytecode.getDoubleBitCast(2.1d)).toUpperCase());
                System.out.println("-2.1d: " + Long.toHexString(PrimitiveTypeBytecode.getDoubleBitCast(-2.1d)).toUpperCase());
                System.out.println("0.0d: " + Long.toHexString(PrimitiveTypeBytecode.getDoubleBitCast(0.0d)).toUpperCase());
                System.out.println("-0.0d: " + Long.toHexString(PrimitiveTypeBytecode.getDoubleBitCast(-0.0d)).toUpperCase());

                System.out.println("C: " + PrimitiveTypeBytecode.getCharBitCast('C'));
                System.out.println("c: " + PrimitiveTypeBytecode.getCharBitCast('c'));
                System.out.println("最: " + PrimitiveTypeBytecode.getCharBitCast('最'));
                System.out.println("韃: " + PrimitiveTypeBytecode.getCharBitCast('韃'));

                System.out.println("2.1f: " + Integer.toHexString(PrimitiveTypeBytecode.getFloatBitCast(2.1f)).toUpperCase());
                System.out.println("-2.1f: " + Integer.toHexString(PrimitiveTypeBytecode.getFloatBitCast(-2.1f)).toUpperCase());

                for (byte b: PrimitiveTypeBytecode.getDoubleBytecode(-2.1d)) {
                System.out.print((b == 0? "00": Integer.toHexString(b).substring(6)).toUpperCase() + " ");
                }
                System.out.println();
                for (byte b: PrimitiveTypeBytecode.getDoubleBytecode(-2.1d, true)) {
                System.out.print((b == 0? "00": Integer.toHexString(b).substring(6)).toUpperCase() + " ");
                }
                System.out.println();

                for (byte b: PrimitiveTypeBytecode.getDoubleBytecode(2910.00023d)) {
                System.out.print(b + " ");
                }
                System.out.println();
                for (byte b: PrimitiveTypeBytecode.getDoubleBytecode(2910.00023d, true)) {
                System.out.print(b + " ");
                }
                System.out.println();

                ByteBuffer byteBuffer = ByteBuffer.allocate(Double.BYTES);
                DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
                doubleBuffer.put(2910.00023d);
                for (byte b: byteBuffer.array()) {
                System.out.print(b + " ");
                }
                System.out.println();

                System.out.println("- - - Float - - -");
                for (byte b: PrimitiveTypeBytecode.getFloatByteCode(2910.00023f, true)) {
                System.out.print(b + " ");
                }
                System.out.println();
                for (byte b: PrimitiveTypeBytecode.getFloatByteCode(2910.00023f, false)) {
                System.out.print(b + " ");
                }
                System.out.println();
*/
/*
        Thread t1 = new Thread(new PureNativeToBytecodeRunnable());
//        Thread t2 = new Thread(new NonReverseNativeByteCodeRunnable());
        Thread t3 = new Thread(new JavaReverseNativeToBytecodeRunnable());
        Thread t4 = new Thread(new DoubleRawToLongToBytecodeRunnable());
        Thread t5 = new Thread(new DoubleBufferToBytecode());

        t1.start();
//        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
//        t2.join();
        t3.join();
        t4.join();
        t5.join();

        Thread.sleep(1000);
*/
