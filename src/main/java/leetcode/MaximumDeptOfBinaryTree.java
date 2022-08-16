package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDeptOfBinaryTree {

    public int getMaximumDept(TreeNode root) {
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
