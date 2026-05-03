import java.util.LinkedList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 1 },
                { 0, 1, 1 },
                { 1, 0, 1 }
        };
        int ans = Solution.orangesRotting(grid);
        System.out.println("Required time to rott :" + ans);
    }
}

class Solution {

    public static int orangesRotting(int[][] grid) {

        int timeRequired = 0;
        Queue<int[]> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        // find all the rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j, 0 });
                }
            }
        }

        while (!queue.isEmpty()) {
            // directions
            int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
            // process current elements

            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int currentTime = current[2];
            timeRequired = Math.max(timeRequired, currentTime);

            // check for neighbours
            for (int[] temp : directions) {
                int dx = temp[0];
                int dy = temp[1];

                int x = row + dx;
                int y = col + dy;

                if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] == 1) {
                    grid[x][y] = 2;
                    queue.add(new int[] { x, y, currentTime + 1 });
                }
            }

        }

        // check for any fine orange
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return timeRequired;
    }
}
