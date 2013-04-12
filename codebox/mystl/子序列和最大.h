int getbiggest(int num[],int size){//гае§Ъ§
	int sum=0;
	int max=0;
	for(int i=0;i<size;i++){
		if(sum<0)
			sum=0;
		sum+=num[i];
		if(sum>max)
			max=sum;
	}
	return max;
}