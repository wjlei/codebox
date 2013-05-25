package main;

import java.util.HashSet;
import java.util.Set;

public class Sudoku_Solver {
  
    public static boolean isValidSudoku(char value,int row,int col,char[][] board){//specific
        boolean res = true;
        for(int i=0;i<9;i++){
            //check row
            if(board[row][i]==value){
                res = false;
                break;
            }
            //check col
            if(board[i][col]==value){
                res = false;
                break;
            }
            //check square
            int row_s = 3*(int)(row/3) + (int)(i/3);
            int col_s = 3*(int)(col/3) + i%3;
            if(board[row_s][col_s]==value){
                res = false;
                break;
            }
        }
        return res;       
    }
    
    public static boolean solve(char[][] board){
	boolean isfind=false;
	int i=0;int j=0;
	for(i=0;i<board.length;i++){
	    for(j=0;j<board[i].length;j++){
		if(board[i][j]=='.'){
		    isfind=true;
		    break;
		}
	    }
	    if(isfind)
		break;
	}
	if (isfind) {
	    for (int v = 1; v <= 9; v++) {
		char value=(char) ('0' + v);
		if (isValidSudoku(value,i,j,board)) {
		    board[i][j] = value;
		    if(solve(board))
			return true;
		}
	    }
	    board[i][j]='.';
	    return false;
	}
	else
	    return true;
    }
    public static void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
	solve(board);
	
    }
    public static void main(String args[]){
	String tt[]={"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
	char num[][]=new char[tt.length][tt[0].length()];
	for(int i=0;i<tt.length;i++){
	    for(int j=0;j<tt[0].length();j++){
		num[i][j]=tt[i].charAt(j);
	    }
	}
	solveSudoku(num);
	System.out.println("11");
	
    }

}    


