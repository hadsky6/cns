import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

class Blowfish {

    private static byte[] encrypt(byte[] key, byte[] str) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(str);
        return encrypted;
    }

    private static byte[] decrypt(byte[] key, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }

    public static void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter any string: ");
            String str = br.readLine();
            System.out.print("Enter  key: ");
            String key = br.readLine();
            byte[] ibyte = str.getBytes();
            byte[] kbyte = key.getBytes();
            byte[] ebyte = encrypt(kbyte, ibyte);
            String encryptedData = new String(ebyte);
            System.out.println("Encrypted message :" + encryptedData);
            byte[] dbyte = decrypt(kbyte, ebyte);
            String decryptedMessage = new String(dbyte);
            System.out.println("Decrypted message :" + decryptedMessage);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}