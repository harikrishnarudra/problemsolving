class Solution {
    private int size;
    private List<List<String>> solutions = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        size=n;
        char[][] emptyBoard = new char[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                emptyBoard[i][j] = '.';
            }
        }
        backtrack(0, new HashSet<>(),new HashSet<>(),new HashSet<>(),emptyBoard);
        return solutions;
    }
    
    private List<String> createBoard(char[][] state){
        List<String> board = new ArrayList<String>();
        for(int row=0;row < size;row++){
            String currRow = new String(state[row]);
            board.add(currRow);
        }
        return board;
    }
    
    
    private void backtrack(int row, Set<Integer> cols, Set<Integer> diagnols, Set<Integer> antiDiagnols, char[][] board){
        //BaseCase
        if(row == size){
            solutions.add(createBoard(board));
            return;
        }
        
        for(int col=0; col < size; col++){
            int currDiagnol = row - col;
            int antiDiagnol = row + col;
            if(cols.contains(col) || diagnols.contains(currDiagnol) || antiDiagnols.contains(antiDiagnol)){
                continue;
            }
            
            cols.add(col);
            diagnols.add(currDiagnol);
            antiDiagnols.add(antiDiagnol);
            board[row][col] = 'Q';
            
            backtrack(row+1, cols, diagnols, antiDiagnols, board);
            
            cols.remove(col);
            diagnols.remove(currDiagnol);
            antiDiagnols.remove(antiDiagnol);
            board[row][col] = '.';
            
        }
    }
}