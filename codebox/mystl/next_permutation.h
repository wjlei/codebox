//4 2          3 1  ->   4 3 2 1 -reverse-->  4 3 1 2
//  |          |
//inorder    bigi/inorder+1
bool next_permutation(int a[], int len)
{
  if(len <=1||NULL==a)
    return false;

  for(int inorder=len-2;inorder>=0;inorder--){
    if(a[inorder] < a[inorder+1])//找到第一个比自己后面的元素小的元素，赋给next;
      {
	int bigi = len-1;
	while(a[inorder]>=a[bigi])//找到右边序列(注意右边序列为降序排列)中最右边的大于自己的元素，将其位置赋给mid。
	  bigi--;
	//交换a[mid]和a[next];右边得到一个新的降序排列的序列。
	swap(a[bigi],a[inorder]);
	reverse(a+inorder+1,a+len);//反转右边的序列，使其升序排列。使右序列最小
	return true;
      }

    if(inorder==0)
      {
	reverse(a,a+len);
	return false;
      }
  }
  return false;
}
