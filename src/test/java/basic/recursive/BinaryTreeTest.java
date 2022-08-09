package basic.recursive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BinaryTreeTest {

    Node two;
    Node three;
    Node root;
    List<Integer> results = new ArrayList<>();

    @BeforeEach
    void setUp() {
        two = new Node(2, new Node(4), new Node(5));
        three = new Node(3, new Node(6), new Node(7));
        root = new Node(1, two, three);
    }

    @Test
    void preorderTest() {
        preorder(root, results);
        assertThat(results).containsExactly(1, 2, 4, 5, 3, 6, 7);
    }

    @Test
    void inorderTest() {
        inorder(root, results);
        assertThat(results).containsExactly(4, 2, 5, 1, 6, 3, 7);
    }

    @Test
    void postorderTest() {
        postorder(root, results);
        assertThat(results).containsExactly(4, 5, 2, 6, 7, 3, 1);
    }

    private void postorder(Node root, List<Integer> results) {
        if (root != null) {
            postorder(root.getLt(), results);
            postorder(root.getRt(), results);
            results.add(root.getData());
        }
    }

    private void inorder(Node root, List<Integer> results) {
        if (root != null) {
            inorder(root.getLt(), results);
            results.add(root.getData());
            inorder(root.getRt(), results);
        }
    }

    private void preorder(Node root, List<Integer> results) {
        if (root != null) {
            results.add(root.getData());
            preorder(root.getLt(), results);
            preorder(root.getRt(), results);
        }
    }

    static class Node {
        private int data;
        Node lt;
        Node rt;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node lt, Node rt) {
            this.data = data;
            this.lt = lt;
            this.rt = rt;
        }

        public int getData() {
            return data;
        }

        public Node getLt() {
            return lt;
        }

        public Node getRt() {
            return rt;
        }
    }

}