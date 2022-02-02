import java.io.*;
import java.util.*;

public class SubstitutionCipher {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String a = "abcdefghijklmnopqrstuvwxyz";
        String b = "zyxwvutsrqponmlkjihgfedcba";
        System.out.print("Enter any string: ");
        String str = br.readLine();
        String encrypt = "";
        String decrypt = "";
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            int j = a.indexOf(c);
            encrypt = encrypt + b.charAt(j);
        }
        System.out.println("The encrypted data is: " + encrypt);
        for (int i = 0; i < str.length(); i++) {
            c = encrypt.charAt(i);
            int j = b.indexOf(c);
            decrypt = decrypt + a.charAt(j);
        }
        System.out.println("The decrypted data is: " + decrypt);
    }
}