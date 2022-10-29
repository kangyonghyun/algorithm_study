package basic.string;

import java.util.Scanner;

public class CryptoGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String digest = sc.next();
        System.out.println(decrypt(digest));
    }

    private static String decrypt(String digest) {
        String plain = "";
        int i = 0;
        int j = 7;
        while (i != digest.length()) {
            String temp = "";
            String substring = digest.substring(i, j);
            for (char c : substring.toCharArray()) {
                if (c == '#') {
                    temp += 1;
                } else {
                    temp += 0;
                }
            }
            plain +=  (char)Integer.parseInt(temp, 2);
            j += 7;
            i += 7;
        }
        return plain;
    }
}
