package basic.treeset;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class NthLargestNumberTest {

    /**
     *  n 번째 크기의 카드의 합 구하기
     *  TreeSet 을 사용해서 중복 숫자 제거, 정렬에 유리한 구조로 만듬
     *  오름차순 정렬 TreeSet 에 3개 카드의 합을 모두 저장
     *  오름차순 정렬된 TreeSet 에 n 번쨰 크기를 구함
     *  TreeSet 은 Set 의 특성 + 이진탐색트리 구조 => 정렬, 검색에 좋고 추가,삭제에 불리
     */

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
            for (int j = i + 2; j < cards.length; j++) {
                sum = first + second + cards[j];
                results.add(sum);
            }
        }
        return results.get(k - 1);
    }

}