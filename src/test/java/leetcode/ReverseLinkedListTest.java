package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 1. LinkedList, Stack 사용
 * 2. ArrayList 로 풀어보자
 */
class ReverseLinkedListTest {

    @Test
    void reverse() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode head = new ListNode(1, two);

        ListNode result = reverseList(head);
        assertThat(result.val).isEqualTo(5);
        assertThat(result.next.val).isEqualTo(4);
        assertThat(result.next.next.val).isEqualTo(3);
        assertThat(result.next.next.next.val).isEqualTo(2);
        assertThat(result.next.next.next.next.val).isEqualTo(1);

        System.out.print(result.val);
        while (result.next != null) {
            result = result.next;
            System.out.print(result.val);
        }
    }

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