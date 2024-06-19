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
    public int maxDepth(TreeNode root) {
       // If the node is null, the depth is 0
        if (root == null) {
            return 0;
        }

        // Recursively find the maximum depth of the left subtree
        int leftDepth = maxDepth(root.left);
        // Recursively find the maximum depth of the right subtree
        int rightDepth = maxDepth(root.right);

        // The depth of the current node is 1 + the maximum of the depths of the left and right subtrees
        return Math.max(leftDepth, rightDepth) + 1;
    }
}