package com.zzg.mybatis.generator.util;

/**
 * @create by  单耀
 * @create date  2020/1/8
 */
public class PathUtil {
    public static String initProjectPathAndDebug() {
        java.net.URL url = PathUtil.class.getProtectionDomain().getCodeSource().getLocation();
        String filePath = null;
        try {
            filePath = java.net.URLDecoder.decode(url.getPath(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (filePath.endsWith(".jar")) {
            filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
        }
        //如果以bin目录接，则说明是开发过程debug测试查询，返回上一层目录
        if (filePath.endsWith("bin/") || filePath.endsWith("bin\\")) {
            filePath = filePath.substring(0, filePath.lastIndexOf("bin"));
        }
        java.io.File file = new java.io.File(filePath);
        filePath = file.getAbsolutePath();
        return filePath;
    }
}
