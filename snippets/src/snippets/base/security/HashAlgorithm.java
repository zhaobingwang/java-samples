package snippets.base.security;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// MessageDigest Algorithms
// https://docs.oracle.com/en/java/javase/14/docs/specs/security/standard-names.html#messagedigest-algorithms
public class HashAlgorithm {
    // 常用哈希算法
    // 算法	        输出长度（位）	输出长度（字节）
    // MD5	        128 bits	    16 bytes
    // SHA-1	    160 bits	    20 bytes
    // RipeMD-160	160 bits	    20 bytes
    // SHA-256	    256 bits	    32 bytes
    // SHA-512	    512 bits	    64 bytes

    // 哈希算法可用于验证数据完整性，具有防篡改检测的功能；
    // 用哈希存储口令时要考虑彩虹表攻击

    public static void run(String algorithm) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 创建一个MessageDigest实例:
        MessageDigest md = MessageDigest.getInstance(algorithm);
        // 反复调用update输入数据:
        md.update("Hello".getBytes("UTF-8"));
        md.update("World".getBytes("UTF-8"));
        byte[] result = md.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
        System.out.println(algorithm + ": " + new BigInteger(1, result).toString(16));
    }
}
