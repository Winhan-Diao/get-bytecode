package com.github.winhandiao;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public class PrimitiveTypeBytecode {
    public static final boolean IS_BIG_ENDIAN;
    private static native boolean stateIfBigEndian();
    @Deprecated
    public static native int getIntBitCast(int n);
    public static native short getCharBitCast(char c);
    public static native long getDoubleBitCast(double d);
    public static native int getFloatBitCast(float f);

    /**
     * Give bytecode under specific endian rule.
     * <p>
     * If the required rule is not the native rule, do a reverse under the hood.
     * **/
    public static native byte[] getDoubleBytecode(double d, boolean isBigEndian);

    /**
     * Give bytecode under native endian rule.
     * **/
    public static native byte[] getDoubleBytecode(double d);

    /**
     * Give bytecode under specific endian rule.
     * <p>
     * If the required rule is not the native rule, do a reverse under the hood.
     * **/
    public static native byte[] getFloatByteCode(float f, boolean isBigEndian);

    /**
     * Give bytecode under native endian rule.
     * **/
    public static native byte[] getFloatByteCode(float f);


//    public static
    static {
        try (InputStream is = new BufferedInputStream(PrimitiveTypeBytecode.class.getResourceAsStream("/com_github_winhandiao_PrimitiveTypeBytecode.dll"))) {
            Path dllPath = Files.createTempFile("tmp-p-", null);
            Files.copy(is, dllPath, StandardCopyOption.REPLACE_EXISTING);
            System.load(dllPath.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        IS_BIG_ENDIAN = stateIfBigEndian();
    }
}
/*
    try {
            System.out.println(PrimitiveTypeBytecode.class.getProtectionDomain().getCodeSource().getLocation());
        String jarDir = new File(PrimitiveTypeBytecode.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();

        // 创建指向同目录下的 "a" 文件的路径
        Path filePath = new File(jarDir, "com_github_winhandiao_PrimitiveTypeBytecode.dll").toPath();

        // 读取文件内容（假设文件内容是文本）
        String fileContent = new String(Files.readAllBytes(filePath));
        System.out.println(fileContent);
        Files.copy(filePath, new File(System.getProperty("java.io.tmpdir")).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (URISyntaxException e) {
        throw new RuntimeException(e);
        } catch (IOException e) {

        }
    System.load(System.getProperty("java.io.tmpdir") + "\\com_github_winhandiao_PrimitiveTypeBytecode.dll");
    IS_BIG_ENDIAN = stateIfBigEndian();

*/
/*
    try {
            String jarPath = PrimitiveTypeBytecode.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        JarFile jarFile = new JarFile(jarPath);
        ZipEntry zipEntry = jarFile.getEntry("com_github_winhandiao_PrimitiveTypeBytecode.dll");
        try (
        InputStream is = jarFile.getInputStream(zipEntry);
        ) {
        System.out.println(Path.of(System.getProperty("java.io.tmpdir")));
        Files.write(Path.of(System.getProperty("java.io.tmpdir")), is.readAllBytes());
        }
        } catch (URISyntaxException | IOException e) {
        throw new RuntimeException(e);
        }
    System.load(System.getProperty("java.io.tmpdir") + "\\com_github_winhandiao_PrimitiveTypeBytecode.dll");
    IS_BIG_ENDIAN = stateIfBigEndian();

*/
/*
    try {
            System.out.println(PrimitiveTypeBytecode.class.getProtectionDomain().getCodeSource().getLocation());
        String jarDir = new File(PrimitiveTypeBytecode.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();

        // 创建指向同目录下的 "a" 文件的路径
        Path filePath = new File(jarDir, "com_github_winhandiao_PrimitiveTypeBytecode.dll").toPath();

        // 读取文件内容（假设文件内容是文本）
        String fileContent = new String(Files.readAllBytes(filePath));
        System.out.println(fileContent);
        Files.write(filePath, fileContent.getBytes());
        System.load(filePath + "com_github_winhandiao_PrimitiveTypeBytecode.dll");
        IS_BIG_ENDIAN = stateIfBigEndian();
        } catch (URISyntaxException | IOException e) {
        throw new RuntimeException(e);
        }


*/
