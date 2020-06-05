package snippets.base.security;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Hmac {
    public static void HmacMD5() throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGen.generateKey();
        byte[] skey = key.getEncoded();
        System.out.println("HmacMD5 Key: " + new BigInteger(1, skey).toString(16));
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = mac.doFinal();
        System.out.println("HmacMD5: " + new BigInteger(1, result).toString(16));
    }
}