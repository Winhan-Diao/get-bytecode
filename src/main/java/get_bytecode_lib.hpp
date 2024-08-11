#include <jni.h>
#include <iostream>
#include <array>

template<class T>
struct std_array_size : std::integral_constant<std::size_t, 0>{};

template<class T, std::size_t N>
struct std_array_size<std::array<T, N>>: std::integral_constant<std::size_t, N>{};


static jboolean stateIfBigEndian() {
    int n = 0x01020304;
    char *cPtr = reinterpret_cast<char *>(&n);
    return *cPtr == 0x01;
}
static jboolean isBigEndian = stateIfBigEndian();

template <class T, std::size_t N = sizeof(T)>
inline std::array<jbyte, N> getBytecodeBufferArray(T t) {
    std::array<jbyte, N> bytecodeBufferArray;
    memcpy(bytecodeBufferArray.data(), &t, N);
    return bytecodeBufferArray;
}

// template <class T, std::size_t N = std::tuple_size<T>::value>
template <class T, std::size_t N = ::std_array_size<T>::value>
inline T&& bufferReverse(T&& bufferPtr) {
    for (int i = 0; i < N / 2; ++i) {
        std::swap<jbyte>(bufferPtr[i], bufferPtr[N - 1 - i]);
    }
    return std::move(bufferPtr);
}
