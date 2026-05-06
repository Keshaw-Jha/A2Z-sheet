import java.util.*;

class Main {
    public static void main(String[] args) {
        int[][] mat = {
                { 0, 0, 1 },
                { 0, 1, 1 },
                { 1, 1, 1 }
        };
        int[][] ans = Solution.updateMatrix(mat);
        for (int[] i : ans) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }
}

class Solution {
    static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];

        // create copy of original
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = mat[i][j];
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == 0) {
                    q.add(new int[] { i, j });
                } else {
                    res[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            for (int[] cord : directions) {
                int dx = x + cord[0];
                int dy = y + cord[1];
                if (0 <= dx && dx < m && 0 <= dy && dy < n && res[dx][dy] == -1) {
                    res[dx][dy] = res[x][y] + 1;
                    q.add(new int[] { dx, dy });
                }
            }
        }
        return res;
    }
}
