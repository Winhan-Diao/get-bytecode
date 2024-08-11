#include "com_github_winhandiao_PrimitiveTypeBytecode.h"
#include "get_bytecode_lib.hpp"
#include <iostream>
#include <cstring>
#include <array>
#include <utility>

JNIEXPORT jboolean JNICALL Java_com_github_winhandiao_PrimitiveTypeBytecode_stateIfBigEndian (JNIEnv *jEnv, jclass jCls) {
    return ::isBigEndian;
}

JNIEXPORT jint JNICALL Java_com_github_winhandiao_PrimitiveTypeBytecode_getIntBitCast (JNIEnv *jEnv, jclass jCls, jint n) {
    return reinterpret_cast<jint& >(n);
}

JNIEXPORT jshort JNICALL Java_com_github_winhandiao_PrimitiveTypeBytecode_getCharBitCast (JNIEnv *jEnv, jclass jCls, jchar c) {
    return reinterpret_cast<jshort& >(c);
}

JNIEXPORT jlong JNICALL Java_com_github_winhandiao_PrimitiveTypeBytecode_getDoubleBitCast (JNIEnv *jEnv, jclass jCls, jdouble d) {
    return reinterpret_cast<jlong& >(d);
}

JNIEXPORT jint JNICALL Java_com_github_winhandiao_PrimitiveTypeBytecode_getFloatBitCast (JNIEnv *jEnv, jclass jCls, jfloat f) {
    return reinterpret_cast<jint& >(f);
}

JNIEXPORT jbyteArray JNICALL Java_com_github_winhandiao_PrimitiveTypeBytecode_getDoubleBytecode__DZ (JNIEnv *jEnv, jclass jCls, jdouble d, jboolean b) {
    jbyteArray bytecode = jEnv->NewByteArray(sizeof(d));    
    if (b == isBigEndian) {
        jEnv->SetByteArrayRegion(bytecode, 0, sizeof(d), reinterpret_cast<jbyte *>(&d));
    } else {
        jEnv->SetByteArrayRegion(bytecode, 0, sizeof(d), bufferReverse(getBytecodeBufferArray(d)).data());
    }
    return bytecode;
}

JNIEXPORT jbyteArray JNICALL Java_com_github_winhandiao_PrimitiveTypeBytecode_getDoubleBytecode__D (JNIEnv *jEnv, jclass jCls, jdouble d) {
    jbyteArray bytecode = jEnv->NewByteArray(sizeof(d));    
    jEnv->SetByteArrayRegion(bytecode, 0, sizeof(d), reinterpret_cast<jbyte *>(&d));
    return bytecode;
}

JNIEXPORT jbyteArray JNICALL Java_com_github_winhandiao_PrimitiveTypeBytecode_getFloatByteCode__FZ (JNIEnv *jEnv, jclass jCls, jfloat f, jboolean b) {
    jbyteArray bytecode = jEnv->NewByteArray(sizeof(f));    
    if (b == isBigEndian) {
        jEnv->SetByteArrayRegion(bytecode, 0, sizeof(f), reinterpret_cast<jbyte *>(&f));
    } else {
        jEnv->SetByteArrayRegion(bytecode, 0, sizeof(f), bufferReverse(getBytecodeBufferArray(f)).data());
    }
    return bytecode;
}

JNIEXPORT jbyteArray JNICALL Java_com_github_winhandiao_PrimitiveTypeBytecode_getFloatByteCode__F (JNIEnv *jEnv, jclass jCls, jfloat f) {
    jbyteArray bytecode = jEnv->NewByteArray(sizeof(f));
    jEnv->SetByteArrayRegion(bytecode, 0, sizeof(f), reinterpret_cast<jbyte *>(&f));
    return bytecode;
}
