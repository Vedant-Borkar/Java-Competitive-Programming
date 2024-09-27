package Trees;
import java.util.*;
public class BFSLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return list;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> l=new ArrayList<>();
            for(int i=0;i<size;i++){
                root=q.poll();
                l.add(root.val);
                if(root.left!=null) q.add(root.left);
                if(root.right!=null) q.add(root.right);
            }
            list.add(l);
        }
        return list;
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
        System.out.println("Level Order Traversal: ");
        List<List<Integer>> arr=levelOrder(root);
        for(var i : arr){
            for( var j : i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
