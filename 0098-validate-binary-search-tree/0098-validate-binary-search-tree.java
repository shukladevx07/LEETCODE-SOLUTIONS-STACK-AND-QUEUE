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
    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorderTraversal(root);
    }

    private boolean inorderTraversal(TreeNode node) {
        if (node == null) {
            return true;
        }
        
        // Traverse the left subtree
        if (!inorderTraversal(node.left)) {
            return false;
        }
        
        // Check current node
        if (prev != null && node.val <= prev) {
            return false;
        }
        prev = node.val;
        
        // Traverse the right subtree
        return inorderTraversal(node.right);
    }
}