package leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 트리문제
 * 1. BFS
 * 2. DFS 로 풀어보기
 */
class MaximumDeptOfBinaryTreeTest {

    @Test
    void TreeTest() {
        TreeNode seven = new TreeNode(7);
        TreeNode fifty = new TreeNode(15);
        TreeNode twenty = new TreeNode(20, fifty, seven);
        TreeNode nine = new TreeNode(9);
        TreeNode root = new TreeNode(3, nine, twenty);

        assertThat(getMaximumDept(root)).isEqualTo(3);
    }

    private int getMaximumDept(TreeNode root) {
        int dept = 0;
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);

        if (root == null) {
            return 0;
        }

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = que.poll();

                if (poll.left != null) {
                    que.offer(poll.left);
                }
                if (poll.right != null) {
                    que.offer(poll.right);
                }
            }
            dept++;
        }
        return dept;
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }


}