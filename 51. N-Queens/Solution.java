import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        char[][] board=new char[n][n];
        List<List<String>> ans=new ArrayList<List<String>>();
        
        for(char[] row : board)
        {
             Arrays.fill(row,'.');
        }
        
        int[] rows =new int[n];
        int[] normalDiagnal=new int[2*n-1];
        int[] reverseDiagnal=new int[2*n-1];
        
        solve(0,board,ans,rows,reverseDiagnal,normalDiagnal);
        
        return ans;
    }
    
    private void solve(int col,char[][] board, List<List<String>> ans,int[] rows, int[] reverseDiagnal,int[] normalDiagnal)
    {
        //base case
        if(col==board.length)
        {
            ans.add(construct(board));
            return;
        }
        
        for(int row=0;row<board.length;row++)
        {
            if(rows[row]==0 && normalDiagnal[row+col]==0 && reverseDiagnal[col-row+board.length-1]==0)
            {
                //set
                board[row][col]='Q';
                rows[row]=1;
                normalDiagnal[row+col]=1;
                reverseDiagnal[col-row+board.length-1]=1;
                
                solve(col+1,board,ans,rows,reverseDiagnal,normalDiagnal);//call the function
                
                //reset/backtrack
                board[row][col]='.';
                rows[row]=0;
                normalDiagnal[row+col]=0;
                reverseDiagnal[col-row+board.length-1]=0;
            }
        }
    }
    
    private List<String> construct(char[][] board)
    {
        List<String> ans =new ArrayList<String>();
        
        for(int i=0;i<board.length;i++)
        {
            String s= new String(board[i]);
            ans.add(s);
        }
        
        return ans;
    }
}