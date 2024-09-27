package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepthBFS {
    public static int maxDepth(TreeNode root) {
        return bfs(root,0);
    }
    public static int bfs(TreeNode root, int depth){
        if(root==null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();//gets current queue size
            for(int i=0;i<size;i++) {//runs till all the current nodes have been removed
                root=q.poll();
                if (root.left != null) q.add(root.left);//new nodes build the next queue
                if (root.right != null) q.add(root.right);
            }
            depth++;//each time the queue is emptied of previous nodes
            //we shift to the next level hence depth is incremented
        }
        return depth;
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
        System.out.print("Height of Binary tree BFS: "+maxDepth(root));
    }
}
