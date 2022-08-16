package leetcode;

import java.util.Stack;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        stack.push(node);

        if (node == null) {
            return null;
        }

        while (node.next != null) {
            node = node.next;
            stack.push(node);
        }
        node = stack.pop();
        ListNode result = node;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            pop.next = null;
            node.next = pop;
            node = pop;
        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}



