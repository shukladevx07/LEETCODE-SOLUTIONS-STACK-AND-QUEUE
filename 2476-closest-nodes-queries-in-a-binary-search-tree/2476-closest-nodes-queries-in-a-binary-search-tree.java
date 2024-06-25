import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> send = new ArrayList<>();
        TreeNode backup = root;  // Store the original root to reset for each query

        for (int q : queries) {
            root = backup;  // Reset the root to the original root before processing each query
            List<Integer> lls = new ArrayList<>();
            int max = -1, min = -1;

            while (root != null) {
                if (root.val == q) {
                    // If the current node's value equals the query
                    min = q;
                    max = q;
                    break;  // Both min and max are found, no need to search further
                } else if (root.val > q) {
                    // If the current node's value is greater than the query
                    max = root.val;  // This could be the potential smallest value greater than or equal to the query
                    root = root.left;  // Move to the left child to find a smaller candidate for max
                } else {
                    // If the current node's value is less than the query
                    min = root.val;  // This could be the potential largest value smaller than or equal to the query
                    root = root.right;  // Move to the right child to find a larger candidate for min
                }
            }

            // Add the found min and max values to the list
            lls.add(min);
            lls.add(max);
            send.add(new ArrayList<>(lls));  // Add the result for this query to the final list
        }

        return send;  // Return the final result for all queries
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
