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

    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        printNode(root,target,k);
        return ans;
        
    }

public void findNodeDistanceDown(TreeNode root,int k){
    if(root==null || k<0)
    return;
    if(k==0){
        ans.add(root.val);
    }
    findNodeDistanceDown(root.left,k-1);
    findNodeDistanceDown(root.right,k-1);
}
    public int printNode(TreeNode root, TreeNode target, int k){
        if(root==null || k<0 )
        return -1;

        if(root == target){
            findNodeDistanceDown(root,k);
            return 1;
        }

        int l= printNode(root.left,target,k);
        if(l!=-1){
            if(l==k)
            ans.add(root.val);
            else
            findNodeDistanceDown(root.right,k-l-1);
            return 1+l;
        }
        int r= printNode(root.right,target,k);
        if(r!=-1){
            if(r==k)
            ans.add(root.val);
            else
            findNodeDistanceDown(root.left,k-r-1);
            return 1+r;
        }
        return -1;
    }
}