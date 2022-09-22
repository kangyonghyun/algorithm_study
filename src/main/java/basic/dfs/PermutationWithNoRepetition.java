package basic.dfs;

import java.util.Scanner;

public class PermutationWithNoRepetition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Permutation permutation = new Permutation(nums, m);
        permutation.printCombination(0);
    }

    static class Permutation {
        int[] nums;
        int[] comination;

        int[] check;

        public Permutation(int[] nums, int m) {
            this.nums = nums;
            this.comination = new int[m];
            this.check = new int[nums.length];
        }

        public void printCombination(int L) {
            if (L == comination.length) {
                for (int c : comination) {
                    System.out.print(c + " ");
                }
                System.out.println();
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (check[i] == 0) {
                        check[i] = 1;
                        comination[L] = nums[i];
                        printCombination(L + 1);
                        check[i] = 0;
                    }
                }
            }
        }
    }

}
