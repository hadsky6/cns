import javax.crypto.*;
import java.util.Scanner;

public class RC4 {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter any string: ");
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        SecretKey skey = KeyGenerator.getInstance("RC4").generateKey();
        Cipher cipher = Cipher.getInstance("RC4");
        cipher.init(Cipher.ENCRYPT_MODE, skey);
        byte[] encrypted = cipher.doFinal((args.length == 0 ? message : args[0]).getBytes());
        System.out.println("\n encrypted string: " + new String(encrypted));
        cipher.init(Cipher.DECRYPT_MODE, skey);
        byte[] original = cipher.doFinal(encrypted);
        System.out.println("\n Original string: " + new String(original));
        sc.close();
    }
}