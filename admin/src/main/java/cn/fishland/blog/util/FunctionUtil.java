package cn.fishland.blog.util;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 相关方法工具类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/21 7:21 下午
 */
public class FunctionUtil {

    public static Logger logger = Logger.getLogger(FunctionUtil.class);

    public static List<String> suffixList;

    static {
        suffixList = Arrays.asList("jpg", "gif", "png", "ico", "bmp", "jpeg");
    }

    public static boolean auth(String key, String name, String password) {
        return password.equals(generateSha256(key, name));
    }

    /**
     * 根据key和名称生成字符串
     *
     * @param key  key
     * @param name 名称
     * @return 生成sha256字符串
     */
    public static String generateSha256(String key, String name) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            String str = key + name;
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("生成sha256失败");
        }
        return encodeStr;
    }

    /**
     * 将byte转为16进制
     *
     * @param bytes 字符数组
     * @return 字符串
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuilder.append("0");
            }
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }

    /**
     * 获得随机uuid
     *
     * @return uuid字符串
     */
    public static String uuid() {
        String uuid = UUID.randomUUID().toString();
        if (StringUtils.isEmpty(uuid)) {
            logger.info("Get UUID string error");
            throw new NullPointerException("Get UUID string error!");
        }
        return uuid.replaceAll("-", "");
    }

    /**
     * 判断是否为图片
     *
     * @return true为图片，否则不为图片
     */
    public static boolean isImag(String suffix) {
        if (StringUtils.hasLength(suffix)) {
            return suffixList.contains(suffix);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "pngs";

        System.out.println(isImag(s));
    }

}
