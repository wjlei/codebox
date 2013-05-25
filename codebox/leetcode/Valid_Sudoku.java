package main;

import java.util.HashSet;
import java.util.Set;

public class Valid_Sudoku {
    public static boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
	for (int i = 0; i < board.length; i++) {// line
	    Set<Character> set = new HashSet<Character>();
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j] == '.')
		    continue;
		if (set.contains(board[i][j])) {
		    return false;
		} else{
		    set.add(board[i][j]);
		}
	    }
	}
	for (int j = 0; j < board[0].length; j++) {// line
	    Set<Character> set = new HashSet<Character>();
	    for (int i = 0; i < board.length; i++) {
		if (board[i][j] == '.')
		    continue;
		if (set.contains(board[i][j])) {
		    return false;
		} else{
		    set.add(board[i][j]);
		}
	    }
	}
	for(int i=0;i<=6;i+=3){
	    for(int j=0;j<=6;j+=3){
		 Set<Character> set = new HashSet<Character>();
		for(int h=i;h<i+3;h++){
		    for(int k=j;k<j+3;k++){
			if (board[h][k] == '.')
			    continue;
			if (set.contains(board[h][k])) {
			    return false;
			} else{
			    set.add(board[h][k]);
			}
			
		    }
		}
	    }
	}
        return true;
    }
    public static void main(String args[]){
	char num[][]=new char[10][20];
	isValidSudoku(num);
    }
}
