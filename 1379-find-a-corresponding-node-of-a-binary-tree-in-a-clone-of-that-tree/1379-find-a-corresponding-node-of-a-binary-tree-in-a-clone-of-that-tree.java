/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // check if treenode is null
        if (original==null){
            return original;
        }
        // intiate a queue for storing nodes
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        // add the root to the queue
        q.add(cloned);
        // while to iterate till last node
        while(!q.isEmpty()){
            // take out the first node from the stack 
            TreeNode temp = q.poll();
            // check if it satifies the condition
            if(temp.val==target.val){
                return temp;
            }
            // if condition does not satifies add its child nodes to the queue
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        return null;
    }
}