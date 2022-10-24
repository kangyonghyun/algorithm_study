package basic.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordsInSentenceTest {

    @Test
    void solution() {
        String sentence = "it is time to study";
        assertThat(getLongestWord1(sentence)).isEqualTo("study");
    }

    private String getLongestWord(String sentence) {
        String longestWord = "";
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (longestWord.length() < word.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    private String getLongestWord1(String sentence) {
        String longestWord = "";
        int max = Integer.MIN_VALUE;
        String[] words = sentence.split(" ");
        for (String word : words) {
            int length = word.length();
            if (max < length) {
                max = length;
                longestWord = word;
            }
        }
        return longestWord;
    }

}