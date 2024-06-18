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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null) {
            if(curr.left == null) {
                ans.add(curr.val); // Current node ka value add karo
                curr = curr.right; // Right child pe move karo
            } else {
                TreeNode prev = curr.left;
                // Find rightmost node in left subtree
                while(prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = curr; // Make temporary link to root
                    curr = curr.left; // Left child pe move karo
                } else {
                    prev.right = null; // Remove temporary link
                    ans.add(curr.val); // Current node ka value add karo
                    curr = curr.right; // Right child pe move karo
                }
            }
        }
        return ans; // Inorder traversal ka result return karo
    }
}