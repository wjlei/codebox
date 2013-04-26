int kthsmallest(int *a,int m,int *b,int n,int k) {
  if (m == 0) {
    return b[k - 1];
  }
  if (n == 0){ 
    return a[k - 1];
  }
  if (k == 1){
    return min(a[0],b[0]);
  }
  if (k == m + n) {
    return max(a[m-1],b[n-1]);
  }
  int i = ((double) m) / (m + n) * (k - 1);//第k个
  int j = k - 1 - i;// 第k+1个
  int  ai_1=i==0?INT_MIN:a[i-1];
  int bj_1=j==0?INT_MIN:b[j-1];
  int ai=i==m?INT_MAX:a[i];
  int bj=j==n?INT_MAX:b[j];
  if(bj_1 <= ai && ai <= bj) //满足第一列i-1,第二列j-1，小于ai，即ai前有k-1个比它小，则ai为K大
    return ai;
  if(ai_1 <= bj && bj <= ai) //满足第一列i-1,第二列j-1，小于bi，即bi前有k-1个比它小，则bi为K大
    return bj;
  if (a[i] <= b[j]){
    return kthsmallest(a+i+1, m-i-1, b, j, k-i-1);//注意减1
  }
  else{
    return kthsmallest(a, i, b+j+1, n-j-1, k-j-1);//注意减1
  }
}
