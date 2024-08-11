package com.github.winhandiao;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ClassTypeBytecode {
    public static final boolean IS_BIG_ENDIAN;
    private static native boolean stateIfBigEndian();
    public static native long getInstanceBitCast(Object o);
    public static native byte[] getInstanceBytecode(Object o, boolean isBigEndian);
    public static native byte[] getInstanceBytecode(Object o);
    static {
        try (InputStream is = new BufferedInputStream(ClassTypeBytecode.class.getResourceAsStream("/com_github_winhandiao_ClassTypeBytecode.dll"))) {
            Path dllPath = Files.createTempFile("tmp-c-", null);
            Files.copy(is, dllPath, StandardCopyOption.REPLACE_EXISTING);
            System.load(dllPath.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        IS_BIG_ENDIAN = stateIfBigEndian();
    }

}
