/*
Prerequisite Search for a value in BST
Prerequisite Insert node in a BST

 */
public class DeleteNodeBST {
    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    static Node deleteNodeBST(Node node, int val) {
        if(node == null) {  // if tree is empty
            return null;
        }

        //Start searching
        if( val < node.val) {
            node.left = deleteNodeBST(node.left, val);
        } else if( val > node.val) {
            node.right = deleteNodeBST(node.right, val);
        } else {   // found the node.
            /*
            if(node.left == null && node.right == null) { // left node
                return null;
            }
             */

            if(node.left == null) { // takes care of both cases where it is a leaf node and or only right exist
                // free(node);
                return node.right; // give my right child to my parent
            } else if(node.right == null) {
                return node.left;
            } else {  //has both child
                int minValue = minValue(node.right);  // or maxValue(node.left)
                node.val = minValue;

                node.right = deleteNodeBST(node.right, minValue); // recursively delete the minValue node

            }
        }
        return node;

    }

    /*
    Get the minimum value from a BST
     */
    static int minValue(Node node) {
        int minValue = node.val;
        for(; node != null; node = node.left) {
            minValue = node.val;
        }
        return  minValue;
    }

    /*
    if(val == node.val) {

    } else if(val < node.val) {

    } else { // means val > node.val
    }



     */
}
