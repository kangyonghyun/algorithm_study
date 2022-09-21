package basic.dfs;

import java.util.Scanner;

public class PermutationWithRepetition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Permutation permutation = new Permutation(sc.nextInt(), sc.nextInt());
        permutation.printNumberOfCases(0);
    }

    static class Permutation {
        int n;
        int[] nums;

        public Permutation(int n, int m) {
            this.n = n;
            this.nums = new int[m];
        }

        private void printNumberOfCases(int L) {
            if (L == nums.length) {
                for (int num : nums) {
                    System.out.print(num + " ");
                }
                System.out.println();
            } else {
                for (int i = 1; i <= n; i++) {
                    nums[L] = i;
                    printNumberOfCases(L + 1);
                }
            }
        }
    }
}
