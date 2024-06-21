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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        findDistance(root, target, k, result);
        return result;
    }
    
    private int findDistance(TreeNode node, TreeNode target, int k, List<Integer> result) {
        if (node == null) {
            return -1;
        }
        
        if (node == target) {
            addSubtreeNodesAtDistanceK(node, k, result);
            return 0;
        }
        
        int leftDistance = findDistance(node.left, target, k, result);
        if (leftDistance != -1) {
            if (leftDistance + 1 == k) {
                result.add(node.val);
            } else {
                addSubtreeNodesAtDistanceK(node.right, k - leftDistance - 2, result);
            }
            return leftDistance + 1;
        }
        
        int rightDistance = findDistance(node.right, target, k, result);
        if (rightDistance != -1) {
            if (rightDistance + 1 == k) {
                result.add(node.val);
            } else {
                addSubtreeNodesAtDistanceK(node.left, k - rightDistance - 2, result);
            }
            return rightDistance + 1;
        }
        
        return -1;
    }
    
    private void addSubtreeNodesAtDistanceK(TreeNode node, int k, List<Integer> result) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0) {
            result.add(node.val);
            return;
        }
        addSubtreeNodesAtDistanceK(node.left, k - 1, result);
        addSubtreeNodesAtDistanceK(node.right, k - 1, result);
    }
}
