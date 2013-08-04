package careercup;
//Pots of gold game: Two players A & B. There are pots of gold arranged in a line,
//each containing some gold coins (the players can see how many coins are there 
//in each gold pot - perfect information). 
//They get alternating turns in which the player can pick a pot from one of the ends of the line.
//The winner is the player which has a higher number of coins at the end. 
//The objective is to "maximize" the number of coins collected by A, assuming B also plays optimally.
//A starts the game. 

public class Pots_of_gold_game {
	static int line[]={1,10,1000,10 };
	static int getsum(int i,int j){
		int sum=0;
		for(int k=i;k<=j;k++){
			sum+=line[k];
		}
		return sum;
	}
	static int solve(){
		int num=line.length;
		int dp[][]=new int[num][num];
		for(int i=0;i<num;i++){
			dp[i][i]=line[i];
		}
		for(int l=1;l<num;l++){
			for(int i=0;i<num-l;i++){
				int j=i+l;
				int sum=getsum(i,j);
				dp[i][j]=sum-Math.min(dp[i][j-1], dp[i+1][j]);
			}
		}
		return dp[0][num-1];
	}
	public static void main(String args[]) {
		System.out.println(solve());
	}
}
