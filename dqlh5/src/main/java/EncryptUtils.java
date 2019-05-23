import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.UUID;

/**
 * 签名工具类
 *
 * @author cunxing
 */
public class EncryptUtils {

    private static final String CHARSET = "utf-8";

    /**
     * 生成AppSecret
     *
     * @param appId
     * @return
     */
    public static String generateAppSecret(String appId) {
        //appId 参数
        String timestamp = System.currentTimeMillis() + "";//当前时间
        String nonce = UUID.randomUUID().toString();//随机数
        return DigestUtils.md5Hex(appId + timestamp + nonce).toUpperCase();
    }

    /**
     * Base64编码
     *
     * @param data
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encodeBase64(String data) throws UnsupportedEncodingException {
        return Base64.encodeBase64String(data.getBytes(CHARSET));
    }

    /**
     * Base64解码
     *
     * @param data
     * @return
     */
    public static String decodeBase64(String data) {
        return new String(Base64.decodeBase64(data));
    }



    public static String getSginSHA1(String appId, String appSecret, String data, String timestamp) throws Exception {
        String finalStr = appId + data + timestamp + appSecret;
        return DigestUtils.sha1Hex(finalStr);
    }
}
