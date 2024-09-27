package Trees;

public class TreeDepthDFS {
    public static int maxDepth(TreeNode root) {
        return dfs(root,0);
    }
    public static int dfs(TreeNode root,int depth){
        if(root==null) return depth;
        return Math.max(dfs(root.left,depth+1),dfs(root.right,depth+1));
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.left.left.left.left = new TreeNode(8);
        System.out.print("Height of Binary tree DFS: "+maxDepth(root));
    }
}
