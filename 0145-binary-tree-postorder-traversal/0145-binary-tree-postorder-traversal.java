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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<>();
        postorder(root,list);
        return list;
    }
    private List<Integer> postorder(TreeNode node,List<Integer> list){
        if(node==null){
            return list;
        }
        postorder(node.left,list);
        postorder(node.right,list);
        list.add(node.val);
        return list;
    }
}