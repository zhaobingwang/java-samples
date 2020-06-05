package snippets.base.security;

public class SecurityHome {
    public static void main(String[] args) {
        System.out.println("security...");
        try {
//            EncodingAlgorithm.url();
//            EncodingAlgorithm.b64();
            HashAlgorithm.run("MD5");
            HashAlgorithm.run("SHA-1");
            HashAlgorithm.run("SHA-256");

            BouncyCastleCrypto.run();

            Hmac.HmacMD5();

            Encrypt.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
