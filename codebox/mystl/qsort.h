int parti(int num[],int left,int right){
  int z=left;
  int i=left;
  for(int j=left+1;j<right;j++){
    if(num[j]<=num[z]){//equal also move to left
      i++;//i and less than i is less or equal axis,so get the next one to change,i++ at the same time
      if(i!=j)
	swap(num[j],num[i]);
    }
  }
  swap(num[left],num[i]);//swap i with axis
  return i;
}
void qsort(int num[],int left,int right){
  if(left<right){
    int mid=parti(num,left,right);
    qsort(num,left,mid-1);
    qsort(num,mid+1,right);
  }
}
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
