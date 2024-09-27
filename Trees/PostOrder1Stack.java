package Trees; /**
 * Definition for a binary tree node.
 * public class Trees.TreeNode {
 *     int val;
 *     Trees.TreeNode left;
 *     Trees.TreeNode right;
 *     Trees.TreeNode() {}
 *     Trees.TreeNode(int val) { this.val = val; }
 *     Trees.TreeNode(int val, Trees.TreeNode left, Trees.TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class PostOrder1Stack{
    public static List<Integer> postorderTraversal(TreeNode root) {
        // Check if the tree is empty
        if (root == null)
            return new ArrayList<>();

        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> postorder = new ArrayList<>();

        // Traverse the tree until
        // current node is not null
        // or the stack is not empty
        while (curr != null || !stack.isEmpty()) {
            // If current node is not null,
            // push it onto the stack
            // and move to its left child
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                // If current node is null,
                // check the right child of the
                // top node in the stack
                TreeNode temp = stack.peek().right;

                // If right child is also null
                // or already visited, it means
                // we can process the top node now
                if (temp == null) {
                    // Get the top node from stack
                    temp = stack.pop();
                    // Add the node's data to
                    // the postorder traversal list
                    postorder.add(temp.val);

                    // Check if there are more
                    // nodes to pop whose right
                    // subtree is also processed
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        postorder.add(temp.val);
                    }
                } else {
                    // If right child exists,
                    // set current node to it
                    curr = temp;
                }
            }
        }
        // Return the list containing the
        // Postorder Traversal Sequence
        return postorder;
    }
    public static void printArrayList(List<Integer> ArrayList) {
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
        List<Integer> result = postorderTraversal(root);

        // Printing the postorder traversal result
        System.out.print("Postorder traversal: ");
        printArrayList(result);
    }
}