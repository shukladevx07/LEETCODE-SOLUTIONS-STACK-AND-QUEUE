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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        helper(root,list);
        int arr[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
       for(int i=0;i<arr.length;i++){
        if(arr[i]<min1){
            min1=arr[i];
        }
       }
       for(int i=0;i<arr.length;i++){
        if(arr[i]<min2 &&arr[i]!=min1){
            min2=arr[i];
        }
       }
       return min2-min1;
    }
    private List<Integer> helper(TreeNode node,List<Integer> list){
        if(node==null){
            return list;
        }
        list.add(node.val);
        helper(node.left,list);
        helper(node.right,list);
        return list;
    }
}