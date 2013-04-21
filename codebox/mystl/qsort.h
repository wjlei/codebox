int parti(int num[],int left,int right){
  if(num==NULL||left<0||right>=totallength)//exception
    return -1;
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
  if(num==NULL||left<0||right>=totallength)//exception
    return ;
  if(left<right){
    int mid=parti(num,left,right);
    if(mid>=0&&left<mid-1)//exception
      qsort(num,left,mid-1);
    if(mid>=0&&mid+1<right)//exception
      qsort(num,mid+1,right);
  }
}
int parti(int num[],int L,int R){
  int v=num[L];
  int i=L+1;int j=R;
  while(1){
    while(num[j]>v)//find j@num <= v;can't set"=",since j is the Axis
      j--;
    while(num[i]<=v){ //find i@num >v
      if(i>=j)// !
	break;
      i++;
    }
    if(i>=j)
      break;
    swap(num[i],num[j]); //swap i,j
  }
  swap(num[j],v);//j is the Axis
  return j;
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
