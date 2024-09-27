package Trees;

import java.util.*;

// Define the Trees.TreeNode structure
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Preordersol {
    // Function to perform preorder traversal
    // of a binary tree iteratively
    public List<Integer> preorderTraversal(TreeNode root) {
        // Initialize list to store
        // the preorder traversal result
        List<Integer> preorder = new ArrayList<>();

        // If the root is null, return
        // an empty traversal result
        if (root == null) {
            return preorder;
        }

        // Create a stack to store
        // nodes during traversal
        Stack<TreeNode> st = new Stack<>();
        // Push the root node
        // onto the stack
        st.push(root);

        // Perform iterative preorder traversal
        while (!st.empty()) {
            // Get the current node
            // from the top of the stack
            root = st.pop();

            // Add the node's value to
            // the preorder traversal result
            preorder.add(root.val);

            // Push the right child
            // onto the stack if exists
            if (root.right != null) {
                st.push(root.right);
            }

            // Push the left child onto
            // the stack if exists
            if (root.left != null) {
                st.push(root.left);
            }
        }

        // Return the preorder
        // traversal result
        return preorder;
    }
}

 class PreorderStack {
    public static void main(String[] args) {
        // Creating a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Initializing the Solution class
        Preordersol sol = new Preordersol();

        // Getting the preorder traversal
        List<Integer> result = sol.preorderTraversal(root);

        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
                            
                        