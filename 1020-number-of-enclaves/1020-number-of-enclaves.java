class Solution {
    public int numEnclaves(int[][] grid) {
        int cnt=0;
        if(grid==null||grid.length==0){
            return 0;
        }
        int n=grid.length;
        int m=grid[0].length;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int[][] vis=new int[n][m];
        for(int j=0;j<m;j++){
            if(vis[0][j]==0&&grid[0][j]==1){
                dfs(0,j,vis,grid,drow,dcol);
            }
            if(vis[n-1][j]==0&&grid[n-1][j]==1){
                dfs(n-1,j,vis,grid,drow,dcol);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i][0]==0&&grid[i][0]==1){
                dfs(i,0,vis,grid,drow,dcol);
            }
            if(vis[i][m-1]==0&&grid[i][m-1]==1){
                dfs(i,m-1,vis,grid,drow,dcol);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                   cnt++;
                }
            }
        }
        return cnt;
    }
    static void dfs(int row, int col, int[][] vis, int[][] mat, int[] delrow, int[] delcol) {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        
        // check for top, right, bottom, left
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            // check for valid coordinates and unvisited Os
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, mat, delrow, delcol);
            }
        }
    }
}