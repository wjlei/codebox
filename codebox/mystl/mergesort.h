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
void mergesort(int a[],int l,int r){//from buttom 0->n-1
  for(int m=1;m<=r-l;m=m*2){//step length
    for(int i=1;i<=r-m;i+=2*m){//one way
      merge(a,i,i+m-1,min(i+m*2-1,r));//m=1:0,0,1  2 nodes[0,1];m=2:0,1,3 4 nodes[0,3]
    }
  }
}
//list mergesort
node merge(node a,node b){
  ndoe head;node c=head;//head "marknode"
  while((a!=NULL)&&(b!=NULL)){
    if(less(a,b)){
      c->next=a;c=c->next;a=a->next;
    }
    else{
      c->next=b;c=c->next;b=b->next;
    }
  }
  c->next=(a==NULL)?b:a;
  return head->next;
}
node mergesort(node c){
  node a,b;
  if(c==NULL||c->next==NULL)// single node or NULL
    return c;
  a=c;b=c->next;
  while(b!=NULL&&b->next!=NULL){
    c=c->next;//c is the cut point
    b=n->next->next;//b get two-step once
  }
  b=c->next;c->next=NULL;//ceiling(n/2) 7 make 1-4 5-7
  return merge(mergesort(a),mergesort(b));//make into two list
}
node mergesort(node t){
  node u;
  queue<node> q;
  for(;t!=NULL;t=u){
    u=t->next;
    t->next=NULL;
    q.push(t);
  }
  t=q.pop();//ensure atleast two node
  while(q.size()>0){
    q.push(t);//ensure atleast two node
    a=q.pop();
    b=q.pop();
    t=merge(a,b);
  }
  return t;
}
