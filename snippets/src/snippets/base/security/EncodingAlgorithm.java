package snippets.base.security;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class EncodingAlgorithm {

    // URL编码的目的是把任意文本数据编码为%前缀表示的文本，便于浏览器和服务器处理；
    public static void url() throws UnsupportedEncodingException {
        String encoded = URLEncoder.encode("中文！", String.valueOf(StandardCharsets.UTF_8));
        System.out.println(encoded);
        System.out.println(URLDecoder.decode(encoded, String.valueOf(StandardCharsets.UTF_8)));
    }

    // Base64编码的目的是把任意二进制数据编码为文本，但编码后数据量会增加1/3。
    public static void b64() {
        byte[] input = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad};
        String b64encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded);

        byte[] output = Base64.getDecoder().decode(b64encoded);
        System.out.println(Arrays.toString(output));
    }
}
