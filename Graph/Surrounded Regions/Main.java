class Main {
    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
            };
        Solution sol = new Solution();
        sol.solve(board);
        printBoard(board);
    }
    
    public static void printBoard(char[][] board){
        int m = board.length;
        int n = board[0].length;
        for(int i = 0 ; i<m;i++){
            for(int j = 0 ; j <n ; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
    }
}

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                dfs(i, 0, board);
            if (board[i][n - 1] == 'O')
                dfs(i, n - 1, board);
        }
        ;

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                dfs(0, j, board);
            if (board[m - 1][j] == 'O')
                dfs(m - 1, j, board);
        }
        ;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == '#'?'O':'X'; 
            }
        }
    }

    public void dfs(int row, int col, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (row < 0 || row == m || col < 0 || col == n) {
            return;
        }
        if (board[row][col] != 'O')
            return;
        board[row][col] = '#';
        dfs(row + 1, col, board);
        dfs(row - 1, col, board);
        dfs(row, col + 1, board);
        dfs(row, col - 1, board);
    }
}
