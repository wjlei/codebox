package prepare;

public class double_n {
	static double solve(double base,int ustime){
		if(ustime==0)
			return 1;
		double half=solve(base,ustime/2);
		if(ustime%2==0)
			return half*half;
		else
			return half*half*base;
	}
	static boolean isvalid=true;
	static double doublen(double base,int time){
		if(time==0)
			return 1;
		if(Math.abs(base-0)<0.00001&&time<0){//1/0 is invalid  !
			isvalid=false;
			return 0;
		}
		if(time<0)
			return 1/solve(base,-time);
		return solve(base,time);
	}
	public static void main(String args[]) {
		System.out.println(doublen(8, 7));
		System.out.println(doublen(8, 0));
		System.out.println(doublen(8, -7));
		System.out.println(Math.pow(8, 7));
		System.out.println(Math.pow(8, 0));
		System.out.println(Math.pow(8, -7));

	}

}
