import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int originalColor = image[sr][sc];
        
        // If the color to fill is the same as the original color, return the image as is
        if (originalColor == color) {
            return image;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;
        
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        
        while (!q.isEmpty()) {
            int[] current = q.remove();
            int row = current[0];
            int col = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == originalColor) {
                    q.add(new int[]{nrow, ncol});
                    image[nrow][ncol] = color;
                }
            }
        }
        
        return image;
    }
}
