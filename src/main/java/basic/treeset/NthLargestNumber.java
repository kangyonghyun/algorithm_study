package basic.treeset;

import java.util.*;

public class NthLargestNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        NthLargestNumber nthLargestNumber = new NthLargestNumber();
        System.out.println(nthLargestNumber.largestNumber(k, n, arr));
    }

    private int largestNumber(int k, int n, Integer[] cards) {
        TreeSet<Integer> cardSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    cardSet.add(cards[i] + cards[j] + cards[l]);
                }
            }
        }
        int count = 0;
        int kTh = -1;
        for (int x : cardSet) {
            count++;
            if (count == k) {
                return x;
            }
        }
        return kTh;
    }

}
