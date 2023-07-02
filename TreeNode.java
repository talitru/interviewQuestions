package il.co.ilrd.InterviewQuestions;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

class Solution {
    public static TreeNode invertTree(TreeNode root) {
        TreeNode temp = null;
        if(root == null || isLeaf(root)){
            return root;
        }

        temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static boolean isLeaf(TreeNode node){
        return (node.left == null && node.right == null) ? true : false;
    }

    public static void main(String[] args){

        TreeNode t3 =  new TreeNode(1, null, null);
        TreeNode t4 =  new TreeNode(3, null, null);
        TreeNode t5 =  new TreeNode(6, null, null);
        TreeNode t6 =  new TreeNode(9, null, null);
        TreeNode t1 =  new TreeNode(2, t3, t4);
        TreeNode t2 =  new TreeNode(7, t5, t6);
        TreeNode root =  new TreeNode(4,t1,t2);

        Solution.invertTree(root);

        System.out.println("root = " + root.val);
        System.out.println("root.left = " + root.left.val);
        System.out.println("root.left.left.val = " + root.left.left.val);
        System.out.println("root.left.right.val = " + root.left.right.val+"\n");
        System.out.println("root.right = " + root.right.val);
        System.out.println("root.right.left.val = " + root.right.left.val);
        System.out.println(" root.right.right.val = " + root.right.right.val);
    }
}