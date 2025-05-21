package utils;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Criptografia {
    private static final String CHAVE = "1234567890123456"; // 16 bytes para AES-128

    public static String criptografar(String texto) throws Exception {
        SecretKeySpec chave = new SecretKeySpec(CHAVE.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        byte[] textoCriptografado = cipher.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(textoCriptografado);
    }

    public static String descriptografar(String textoCriptografado) throws Exception {
        SecretKeySpec chave = new SecretKeySpec(CHAVE.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, chave);
        byte[] textoDecifrado = cipher.doFinal(Base64.getDecoder().decode(textoCriptografado));
        return new String(textoDecifrado);

    }
}