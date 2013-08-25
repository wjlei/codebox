package prepare;


//count the num of x ,find the left and right boundary
public class left_and_right_boundary {
	public static void main(String args[]){
		int num[]={1,2,4,5,6};
		int left=findleft(num,3);
		int right=findright(num,3);
		System.out.print(right-left+1);
	
	}
	static int findleft(int num[],int x){
		int left=0;int right=num.length;
		while(left<=right){
			int mid=(left+right)/2;
			if(num[mid]<x){
				left=mid+1;
			}
			else if(num[mid]>=x){
				right=mid-1;
			}
		}
		return left;
	}
	static int findright(int num[],int x){
		int left=0;int right=num.length;
		while(left<=right){
			int mid=(left+right)/2;
			if(num[mid]<=x){
				left=mid+1;
			}
			else if(num[mid]>x){
				right=mid-1;
			}
		}
		return right;
	}
	

}
