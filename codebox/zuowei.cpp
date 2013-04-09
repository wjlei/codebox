#include <stdio.h>
//求a的阶乘:a!
int rank(int a){
  int sum=1;
  for(int i=a;i>0;i--)
    sum=sum*i;
  return sum;
}
void sort(int *s,int length){
  int i,j,c;
  length=length-1;//比较次数
  for(i=0;i<length;i++){
    for(j=0;j<length-i;j++){
      if(s[j]<s[j+1]){
	c=s[j];
	s[j]=s[j+1];
	s[j+1]=c;
      }
    }
  }
}
//对大小为sums的座位排序，a数组为对大小为sums的排序问题的数组，length为数组长度，
//其中before记为前一个座位系别号,nums返回累加后的排列组合次数。
int recursive_arrange(int *a,int length,int sums,int before,int *nums){
  int j,result=1;
  int flag=-1;
  if((sums==0))//考虑完所有元素情况
    {
      *nums+=1;
      return 1;
    }
  sums--;
  for(j=0;j<length;j++){
  
    int *s=new int[length];
    for(int i=0;i<length;i++){
      s[i]=a[i];
    }
    if((s[j]>0)&&(j!=before)){
     
      s[j]-=1;
      flag=1;
      //输出中间结果，方便分析
      /*printf("\nsums:=%d ",sums);
	for(int i=0;i<length;i++)
	{
	printf("s[%d]=%d ",i,s[i]);
	}*/
      result=recursive_arrange(s,length,sums,j,nums);
    }
  }
  if((flag==-1)||(result==0))
    return 0;
  else{
    return 1;
  }
   
}
int main(){
  int M=1000000007;
  int t,n;
  scanf("%d",&t);
 
  int i,j,temp,factor,sums;//座位数 
 
  int flag=1;//存在
  for(i=0;i<t;i++){   
    //每一轮的初始化工作
    factor=1;
    sums=0;
    int *nums;//总的排序方法数
    int b=0;
    nums=&b;
    scanf("%d",&n);
    int *a=new int[n];        
    for(j=0;j<n;j++){//初始化
      scanf("%d",a+j);
      sums+=a[j];
    }
    //先将数组从大到小排序，预处理
    sort(a,n);
    temp=2*a[0];
    //数组中最大元素若大于（sums+1）/2，则直接返回0
    if(temp<=sums+1){
      for(j=0;j<n;j++){
	factor*=rank(a[j]);   
      }
     
      recursive_arrange(a,n,sums,-1,nums);
      (*nums)*=factor;
      (*nums)=(*nums)%M;
   
    }
    else
      *nums=0;  
    printf("case %d: %d\n",i+1,*nums);
     
  }   
  return 1;
}
