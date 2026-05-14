// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,1,1},
                        {1,0,0,0,0},
                        {0,0,0,0,1},
                        {1,1,0,1,1}};
                        
        Solution sol = new Solution();
        int ans = sol.countDistinctIslands(grid);
        System.out.print(ans);
    }
}

class Solution{
    public int countDistinctIslands(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        
        for(int i = 0 ;i<m;i++){
            visited[i] = Arrays.copyOf(grid[i],n);
        }
        
        Set<String> islands = new HashSet<>();
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(visited[i][j]==1){
                    StringBuilder island = new StringBuilder();
                    dfs(i,j,i,j,island,visited);
                    islands.add(island.toString());
                }
            }
        }
        return islands.size();
    }    
    
    public void dfs(int row, int col, int baseRow, int baseCol, StringBuilder island, int[][] visited){
        int m = visited.length;
        int n = visited[0].length;
        
        if(row<0 || row>=m || col<0 || col>=n ) return;
        
        if(visited[row][col]!=1) return;
        visited[row][col] = -1;
        
        int diffRow = baseRow-row;
        int diffCol = baseCol-col;
        island.append(diffRow+","+diffCol+",");
        
        dfs(row+1, col, baseRow, baseCol, island, visited);
        dfs(row-1, col, baseRow, baseCol, island, visited);
        dfs(row, col+1, baseRow, baseCol, island, visited);
        dfs(row, col-1, baseRow, baseCol, island, visited);
    }
}
