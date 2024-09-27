package Trees;
import java.util.*;

// TreeNode class for the binary tree
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    // Constructor to initialize
//    // the TreeNode with a value
//    TreeNode(int val) {
//        val = val;
//        left = null;
//        right = null;
//    }
//}

class BinaryTreePostorder2Stacks {
    // Function to return the postOrder
    // traversal of a binary tree using
    // two stacks
    public static ArrayList<Integer> postOrder(TreeNode root) {
        // ArrayList to store postorder traversal
        ArrayList<Integer> postorder = new ArrayList<>();

        // If the tree is empty, return an empty traversal
        if (root == null) {
            return postorder;
        }

        // Two stacks for iterative traversal
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        // Push the root TreeNode onto the first stack
        st1.push(root);

        // Iterative traversal to populate st2 with nodes in postorder
        while (!st1.empty()) {
            // Get the top TreeNode from st1
            root = st1.pop();

            // Push the TreeNode onto st2
            st2.push(root);

            // Push left child onto st1 if exists
            if (root.left != null) {
                st1.push(root.left);
            }

            // Push right child onto st1 if exists
            if (root.right != null) {
                st1.push(root.right);
            }
        }

        // Populate the postorder traversal ArrayList by popping st2
        while (!st2.empty()) {
            postorder.add(st2.pop().val);
        }

        // Return the postorder traversal
        return postorder;
    }

    // Function to print the
    // elements of a ArrayList
    public static void printArrayList(ArrayList<Integer> ArrayList) {
        // Iterate through the ArrayList
        // and print each element
        for (int num : ArrayList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Getting postorder traversal
        ArrayList<Integer> result = postOrder(root);

        // Printing the postorder traversal result
        System.out.print("Postorder traversal: ");
        printArrayList(result);
    }
}

