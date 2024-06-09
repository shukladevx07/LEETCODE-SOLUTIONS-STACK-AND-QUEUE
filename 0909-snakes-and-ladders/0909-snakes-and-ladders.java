import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        
        // Convert board's 2D coordinates to a 1D label
        int[] flattenBoard = new int[n * n + 1];
        int idx = 1;
        boolean isRight = true;
        for (int i = n - 1; i >= 0; i--) {
            if (isRight) {
                for (int j = 0; j < n; j++) {
                    flattenBoard[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    flattenBoard[idx++] = board[i][j];
                }
            }
            isRight = !isRight;
        }

        // BFS Initialization
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;
        int moves = 0;

        // BFS Process
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == n * n) {
                    return moves;
                }
                for (int j = 1; j <= 6; j++) {
                    int next = current + j;
                    if (next > n * n) {
                        break;
                    }
                    if (flattenBoard[next] != -1) {
                        next = flattenBoard[next];
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
}
