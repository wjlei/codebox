#include<iostream>
#include<stdio.h>
#include<math.h>
#include<limits.h>
#include<queue>
using namespace std;
int const maxn=100000;
int const maxm=2000000;
struct node{
  int t,w;
  node *next;
}edge[maxm],*adj[maxn],*nadj[maxn];//edge保存边的数组 adj保存顺的边,nadj保存逆的边
int len=0;
void init(int n){
  for(int i=0;i<=n;i++){
    adj[i]=NULL;nadj[i]=NULL;
  }
  len=0;
}
void addedge(node *adj[],int u,int v,int w){
  edge[len].t=v;
  edge[len].w=w;
  edge[len].next=adj[u];
  adj[u]=&edge[len++];//u->v
}
void insert(int u,int v,int w)
{
  addedge(adj,u,v,w);
  addedge(adj,v,u,w);
}
int use[maxn];
long long dis[maxn];
queue<int>Q;
void SPFA(node *adj[],int n,int s)
{
  while(!Q.empty())
    Q.pop();
  fill(use,use+n,0);
  fill(dis,dis+n,INT_MAX);
  Q.push(s);
  use[s]=1;//起点被使用
  dis[s]=0;
  while(!Q.empty())
    {
      int t=Q.front();
      Q.pop();
      use[t]=0;
      for(node *p=adj[t];p;p=p->next){
	if(dis[t]+p->w<dis[p->t]){
	  dis[p->t]=dis[t]+p->w;
	  if(!use[p->t]){
	    use[p->t]=1;
	    Q.push(p->t);
	  }
	}
      }
    }
}

int main(){
#ifdef _DEBUG
  freopen("data","r",stdin);
#endif
  int T;
  cin>>T;
  while(T--)
    {
      int n,m;
      scanf("%d%d",&n,&m);
      init(n);
      for(int i=0;i<m;i++)
	{
	  int a,b,c;
	  scanf("%d%d%d",&a,&b,&c);
	  insert(a,b,c);
	}
      int numser;
      scanf("%d",&numser);
      for(int i=0;i<numser;i++){
	int s;
	scanf("%d",&s);
	insert(0,s,0);
      }
      SPFA(adj,n+1,0);
      int nq;
      scanf("%d",&nq);
      for(int i=0;i<nq;i++){
	int dnum;
	scanf("%d",&dnum);
	if(dis[dnum]==INT_MAX)
	  printf("-1\n");
	else
	  printf("%d\n",dis[dnum]);
      }
      printf("\n");
		
    }
#ifdef _DEBUG
  freopen("CON","r",stdin);
  system("pause");
#endif
  return 0;
}
