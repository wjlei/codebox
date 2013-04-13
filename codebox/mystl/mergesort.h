void mergeAB(int c[],int a[],int n,int b[],int m){
	int i=0,j=0;
	for(int k=0;k<m+n;k++){
		if(i==n){
			c[k]=b[j++];
			continue;
		}
		if(j==m){
			c[k]=b[i++];
			continue;
		}
		c[k]=a[i]<b[j]?a[i++]:b[j++];
	}
}
int aux[maxN];
void merge(int a[],int l,int m,int r){
	int i,j;
	for(i=m;i>=l;i--)//inorder l->m
		aux[i]=a[i];
	for(j=m+1;j<=r;j++)//reverse m+1->r
		aux[r+m+1-j]=a[j];
	for(int k=l;k<=r;k++)
		a[k]=aux[j]<aux[i]?aux[j--]:aux[i++];
}
void mergesort(int a[],int l.int r){//from top
	if(r<=l)
		return ;
	int m=(r+l)/2;
	mergesort(a,l,m);
	mergesort(a,m+1,r);
	merge(a,l,m,r);
}
void mergesort(int a[],int l,int r){
	for(int m=1;m<=r-l;m=m*2){//step length
		for(int i=1;i<=r-m;i+=2*m){//one way
			merge(a,i,i+m-1,min(i+m*2-1,r));
		}
	}
}