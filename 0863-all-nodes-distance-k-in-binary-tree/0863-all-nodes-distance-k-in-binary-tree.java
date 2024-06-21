import java.util.*;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        // Step 1: Create a parent map using DFS
        createParentMap(root, null, parentMap);

        // Step 2: Perform BFS from the target node
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            if (currentLevel == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null && visited.add(current.left)) {
                    queue.add(current.left);
                }
                if (current.right != null && visited.add(current.right)) {
                    queue.add(current.right);
                }
                TreeNode parent = parentMap.get(current);
                if (parent != null && visited.add(parent)) {
                    queue.add(parent);
                }
            }
            currentLevel++;
        }

        return result;
    }

    private void createParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node != null) {
            parentMap.put(node, parent);
            createParentMap(node.left, node, parentMap);
            createParentMap(node.right, node, parentMap);
        }
    }
}
