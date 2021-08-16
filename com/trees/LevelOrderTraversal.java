import java.util.ArrayDeque;
import java.util.Deque;

/*
       0
      / \
     1   2
    /     \
   3       4
 */
public class LevelOrderTraversal {
    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;

        levelOrder(root); // o/p: 0, 1, 2, 3, 4
    }

    static void levelOrder(Node root) {
        if(root == null) {
            return;
        }
        Deque<Node> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();  // remove from Q and assigns to node

            //process node
            System.out.print(node.val + " ");

            Node leftNode = node.left;
            Node rightNode = node.right;

            if(leftNode != null) {
                queue.offer(leftNode); //puts the end of the Q
            }
            if(rightNode != null) {
                queue.offer(rightNode);
            }
        }

    }
    
}
