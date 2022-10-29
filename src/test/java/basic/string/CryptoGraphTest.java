package basic.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CryptoGraphTest {

    @Test
    void solution() {
        int n = 4;
        String digest = "#****###**#####**#####**##**";
        assertThat(decrypt1(digest)).isEqualTo("COOL");
    }

    private String decrypt(String digest) {
        String plain = "";
        int i = 0;
        int j = 7;
        while (i != digest.length()) {
            String temp = "";
            String substring = digest.substring(i, j);
            temp = toBinary(temp, substring);
            plain +=  (char)Integer.parseInt(temp, 2);
            j += 7;
            i += 7;
        }
        return plain;
    }

    private static String toBinary(String temp, String substring) {
        for (char c : substring.toCharArray()) {
            if (c == '#') {
                temp += 1;
            } else {
                temp += 0;
            }
        }
        return temp;
    }

    private String decrypt1(String digest) {
        String plain = "";
        for (int i = 0; i < digest.length(); i++) {
            String replace = digest.substring(0, 7)
                    .replace('#', '1')
                    .replace('*', '0');
            plain += (char)Integer.parseInt(replace, 2);
            digest = digest.substring(7);
        }
        return plain;
    }

}