import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        boolean[] visited = new boolean[amount + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(amount);
        visited[amount] = true;

        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                for (int coin : coins) {
                    int next = current - coin;
                    if (next == 0) {
                        return level;
                    } 
                    if (next > 0 && !visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return -1;
    }
}
