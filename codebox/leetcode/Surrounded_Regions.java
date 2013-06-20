package main1;

import java.util.LinkedList;
import java.util.Queue;

public class Surrounded_Regions {
	Queue<Integer> q=new LinkedList<Integer>();
	int m;
	int n;
	char[][] board;
	void fill(int i,int j){
		if(i<0||i>=m||j<0||j>=n||board[i][j]!='O')
			return ;
		 q.offer(i*m+j);
		 board[i][j]='D';
	}
	void bfs(int i, int j) {
		fill(i,j);
		while(!q.isEmpty()){
			int temp=q.poll();
			int ti=temp/m;
			int tj=temp%m;
			fill(ti+1,tj);
			fill(ti,tj+1);
			fill(ti-1,tj);
			fill(ti,tj-1);
		}
	}


	public void solve(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (board==null||board.length == 0 || board[0].length == 0)
			return;
		this.board=board;
		m=board.length;
		n=board[0].length;
		for(int i=0;i<m;i++){
			if (board[i][0] == 'O')
				bfs(i, 0);
			if (board[i][n - 1] == 'O')
				bfs(i, n - 1);
		}
		for (int j = 1; j < n-1; j++) {
			if (board[0][j] == 'O')
				bfs(0, j);
			if (board[m - 1][j] == 'O')
				bfs(m - 1, j);
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(board[i][j]=='O')
					board[i][j]='X';
				else if(board[i][j]=='D')
				    board[i][j]='O';
			}
		}
	}

}
