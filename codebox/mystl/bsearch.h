int bsearch(int num[],int x,int left,int right){
	while(left<=right){
		int mid=left+(right-left)/2;//×¢ÒâÒç³ö
		if(num[mid]==x)
			return mid;
		else if(num[mid]>x)
			right=mid-1;
		else if(num[mid]<x)
			left=mid+1;
	}
	return -1;
}