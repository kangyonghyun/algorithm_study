package treeset;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NthLargestNumberTest {

    @Test
    void nthNumber() {
        int total = 10;
        int k = 3;
        Integer[] cards = {13, 15, 34, 23, 45, 65, 33, 11, 26, 42};
        assertThat(kThLargestNumber(k, total, cards)).isEqualTo(143);
    }

    private int kThLargestNumber(int k, int total, Integer[] cards) {
        TreeSet<Integer> cardSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                for (int l = j + 1; l < total; l++) {
                    cardSet.add(cards[i] + cards[j] + cards[l]);
                }
            }
        }
        int count = 0;
        int result = 0;
        for (int x : cardSet) {
            count++;
            if (count == k) {
                return x;
            }
        }
        return result;
    }

    private int nThLargestNumber(int k, Integer[] cards){
        Arrays.sort(cards, Collections.reverseOrder());
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < cards.length - 1; i++) {
            int sum = 0;
            int first = cards[i];
            int second = cards[i + 1];
            for (int j = i+2; j < cards.length; j++) {
                sum = first + second + cards[j];
                results.add(sum);
            }
        }
        return results.get(k-1);
    }

}