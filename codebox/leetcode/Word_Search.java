package main2;

import java.util.ArrayList;
import java.util.Arrays;

public class Word_Search {
   static boolean solve(char[][] board,int num[][],int[][] state,int index,int starti,int startj,String temp,String word){
	if(temp.equals(word)){
	    return true;
	}
	for(int i=0;i<4;i++){
	    int newi=starti+num[i][0];
	    int newj=startj+num[i][1];
	    if((newi>=0&&newi<board.length)&&(newj>=0&&newj<board[0].length)&&state[newi][newj]==0){
		if(index+1<=word.length()&&word.charAt(index)==board[newi][newj]){
		    state[newi][newj]=1;
		    if(solve(board,num,state,index+1,newi,newj,temp+board[newi][newj],word))
		        return true;
		    state[newi][newj]=0;
		}
	    }
	}
	return false;
	
    }
    public static boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
	int num[][]={{1,0},{0,1},{-1,0},{0,-1}};
	int m=board.length;
	int n=board[0].length;
	for(int i=0;i<m;i++){
	    for(int j=0;j<n;j++){
		if(1<=word.length()&&word.charAt(0)==board[i][j]){
		    int state[][]=new int[m][n];//new
		    state[i][j]=1;
		    if(solve(board,num,state,1,i,j,""+board[i][j],word))
		        return true;
		}
	    }
	}
	return false;
    }
    public static void main(String ards[]){
	char[][] board={{'a'}};
System.out.println(exist(board, "a"));
	
    }

}
