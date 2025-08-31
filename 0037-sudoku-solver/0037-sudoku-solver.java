class Solution {
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
        printBoard(board);
    }
    public boolean solve(char[][] board,int row ,int col){
        if(row==9){
            return true;
        }

        int nextRow = row ;
        int nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol =0;
        }
        if(board[row][col]!='.'){
            return solve(board,nextRow,nextCol);
        }

        if(board[row][col]=='.'){
            for(char digit='1';digit<='9';digit++){
                if(isSafe(board,row,col,digit)){
                    board[row][col]= digit ;
                    if(solve(board,nextRow,nextCol)){
                        return true;
                    }
                    board[row][col]='.';
                }

            }
        }
        return false;
        
    }
    public static boolean isSafe(char[][] board,int row ,int col,char digit){
        //row check
        for(int i =0;i<9;i++){
            if(board[i][col]==digit){
                return false;
            }
        }
        //column check
        for(int i =0;i<9;i++){
            if(board[row][i]==digit){
                return false;
            }
        }
        //grid check
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i = sr ;i<sr+3;i++){
            for(int j =sc ;j<sc+3;j++){
                if(board[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }

    private void printBoard(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}