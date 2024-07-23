class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        
        // Build the reversed graph and indegree array
        for (int i = 0; i < V; i++) {
            for (int node : graph[i]) {
                adjRev.get(node).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for (int neighbor : adjRev.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
