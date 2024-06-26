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
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0; // If the tree is empty, the width is 0.

        int maxWidth = 0; // Initialize the maximum width.

        // Use a queue to perform BFS. Each element in the queue is a pair (node, position).
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0)); // Start with the root node at position 0.

        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at the current level.
            int minPosition = queue.peek().getValue(); // Position of the first node at this level.

            int first = 0, last = 0; // Positions of the first and last nodes at this level.

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> current = queue.poll();
                TreeNode node = current.getKey();
                int position = current.getValue() - minPosition; // Normalize to avoid overflow.

                if (i == 0) first = position; // Set the position of the first node.
                if (i == size - 1) last = position; // Set the position of the last node.

                if (node.left != null) queue.add(new Pair<>(node.left, 2 * position)); // Add left child to the queue.
                if (node.right != null) queue.add(new Pair<>(node.right, 2 * position + 1)); // Add right child to the queue.
            }

            maxWidth = Math.max(maxWidth, last - first + 1); // Update the maximum width.
        }

        return maxWidth; // Return the maximum width found.
    }
}

// A simple helper class to hold the pair of node and its position.
class Pair<K, V> {
    private K key;
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
}
