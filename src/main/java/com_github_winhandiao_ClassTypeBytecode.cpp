#include "com_github_winhandiao_ClassTypeBytecode.h"
#include "get_bytecode_lib.hpp"


JNIEXPORT jboolean JNICALL Java_com_github_winhandiao_ClassTypeBytecode_stateIfBigEndian (JNIEnv *jEnv, jclass jCls){
    return ::isBigEndian;
}

JNIEXPORT jbyteArray JNICALL Java_com_github_winhandiao_ClassTypeBytecode_getInstanceBytecode__Ljava_lang_Object_2Z (JNIEnv *jEnv, jclass jCls, jobject o, jboolean b) {
    jbyteArray bytecode = jEnv->NewByteArray(sizeof(o));    
    if (b == isBigEndian) {
        jEnv->SetByteArrayRegion(bytecode, 0, sizeof(o), getBytecodeBufferArray(o).data());
    } else {
        jEnv->SetByteArrayRegion(bytecode, 0, sizeof(o), bufferReverse(getBytecodeBufferArray(o)).data());
    }
    return bytecode;
}

JNIEXPORT jbyteArray JNICALL Java_com_github_winhandiao_ClassTypeBytecode_getInstanceBytecode__Ljava_lang_Object_2 (JNIEnv *jEnv, jclass jCls, jobject o) {
    jbyteArray bytecode = jEnv->NewByteArray(sizeof(o));    
    jEnv->SetByteArrayRegion(bytecode, 0, sizeof(o), reinterpret_cast<jbyte *>(&o));
    return bytecode;
}
