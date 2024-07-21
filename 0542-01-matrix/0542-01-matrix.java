import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] distance = new int[row][col];
        Queue<int[]> q = new LinkedList<>();

        // Initialize the distance array and enqueue all 0s
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    distance[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Directions array for moving up, right, down, and left
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        // BFS to update distances
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < row && ncol >= 0 && ncol < col) {
                    if (distance[nrow][ncol] > distance[r][c] + 1) {
                        distance[nrow][ncol] = distance[r][c] + 1;
                        q.add(new int[]{nrow, ncol});
                    }
                }
            }
        }

        return distance;
    }
}
