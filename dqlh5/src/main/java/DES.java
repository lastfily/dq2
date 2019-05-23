import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;


/**
 * RSA非对称加密/解密
 *
 * @author cunxing
 */
public class DES {

    /**
     * 加解密算法
     */
    public static final String ALGORITHM = "DES";

    public static final String UTF8 = "UTF-8";

    private static byte[] iv = {1, 2, 3, 4, 5, 6, 7, 8};

    /**
     * 加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String key) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, secureRandom);
        return cipher.doFinal(data);
    }

    /**
     * 解密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String key) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, secureRandom);
        return cipher.doFinal(data);
    }

    /**
     * 加密(字符串)
     *
     * @param input
     * @param key
     * @return
     */
    public static String encryptString(String input, String key) {
        try {
            byte[] data = encrypt(input.getBytes(), key);
            return Base64.encodeBase64String(data);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密(字符串)
     *
     * @param input
     * @param key
     * @return
     */
    public static String decryptString(String input, String key) {
        try {
            byte[] data = Base64.decodeBase64(input);
            return new String(decrypt(data, key));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 兼容iOS
     *
     * @param encryptString
     * @param encryptKey
     * @return
     * @throws Exception
     */
    public static String encryptDES(String encryptString, String encryptKey) {
        try {
            IvParameterSpec zeroIv = new IvParameterSpec(iv);
            SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
            byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
            return Base64.encodeBase64String(encryptedData);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 兼容IOS
     * 
     * @param decryptString
     * @param decryptKey
     * @return
     */
    public static String decryptDES(String decryptString, String decryptKey) {
        try {
            IvParameterSpec zeroIv = new IvParameterSpec(iv);
            byte[] data = Base64.decodeBase64(decryptString);
            SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
            byte[] decryptedData = cipher.doFinal(data);
            return new String(decryptedData);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String key;
        key = "E72E3941";
        System.out.println("key:" + key);
        String content = "{\"gpslat\":39.90403,\"gpslon\":116.407526,\"areaId\":\"10011\",\"subId\":\"\",\"apikey\":\"5A31F145DB50C33ED5867A2EA58A3C44\",\"custId\":445852,\"bannarId\":4241}";
        System.out.println("content:" + content);
        String encryptStr = encryptString(content, key);
//        String encryptStr = encryptDES(content, key);
        System.out.println("result:" + encryptStr);
        System.out.println("original(content):" + decryptDES("RgYqr9PpybIVDJTrAi4+8+zKjAc3e+E+1cGn75T68+6OWggC3dg6uBa0z+D9grYcXHu/3TdLzbFJz8VpkwDFmKSOm+FisuXHXgZA6jwNVIjvfzRMw9tlLpjJWYdfScjMFvis18rxkYPSmxLcUqrVILZtJyVsCDZ5uwORldSK161K1BiQJlVavDO6WRgEBgS9BqtbahXJdgo=", key));
//        System.out.println("original(content):" + decryptString(encryptStr, key));
    }

}
