import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        if (root != null) {
            helper(root, "", list);
        }
        return list;
    }

    private void helper(TreeNode node, String path, List<String> list) {
        if (node != null) {
            path += Integer.toString(node.val);
            if (node.left == null && node.right == null) {  // if leaf node
                list.add(path);  // add path to list
            } else {
                path += "->";  // extend path
                helper(node.left, path, list);
                helper(node.right, path, list);
            }
        }
    }
}
