int parti(int num[],int left,int right){
	int z=left;
	while(left<right){
		while(left<right&&num[z]<=num[right])
			right--;
		swap(num[z],num[right]);
		z=right;
		while(left<right&&num[z]>num[left])
			left++;
		swap(num[left],num[z]);
		z=left;
	}
	return z;
}
void qsort(int num[],int left,int right){
	if(left<right){
		int mid=parti(num,left,right);
		qsort(num,left,mid-1);
		qsort(num,mid+1,right);
	}
}