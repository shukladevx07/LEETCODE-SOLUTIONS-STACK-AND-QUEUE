/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
       return helper(root,false);
    }
    private int helper(TreeNode node,boolean isleft){
        if(node==null){
            return 0;
        }
        if(node.left==null&&node.right==null&&isleft==true){
            return node.val;
        }
        return helper(node.left,true)+helper(node.right,false);
    }
}