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
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftheight=minDepth(root.left);
        int rightheight=minDepth(root.right);
         if(root.left == null)
            return 1 + rightheight;
        if(root.right == null)
            return 1 + leftheight;

        return Math.min(leftheight,rightheight)+1;
    }
}