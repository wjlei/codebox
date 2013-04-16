/*
algorithm : Edmonds-Karp

Memory 764K Time 0MS    Language G++

code by : zhyu
*/
#include <cstdio>
#include <cstring>
#include <queue>
#include <algorithm>
#define inf 0x7fffffff
#define N 205
using namespace std;
int map[N][N],path[N],flow[N],start,end,m,n;
queue<int> q;
int bfs(void)//寻找增广路，用广度优先
{
	register int i;
	int t;
	while(!q.empty()) q.pop();
	memset(path,-1,sizeof(path));
	path[start]=0,flow[start]=inf;
	q.push(start);
	while(!q.empty())
	{
		t=q.front();
		q.pop();
		if(t==end) break;
		for(i=1;i<=m;i++)//寻找下一个连接点
		{
			if(i!=start && path[i]==-1 && map[t][i])//不是起点，未被访问过，剩余流大于0
			{
				flow[i]=flow[t]<map[t][i]?flow[t]:map[t][i];//增广路选择最小流
				q.push(i);
				path[i]=t;
			}
		}
	}
	if(path[end]==-1) return -1;
	return flow[m];
}
int EK(void)
{
	int max_flow=0,step,pre,now;
	while((step=bfs())!=-1)//获得增广路的最小流
	{
		max_flow+=step;//最大流加上该次最小流
		now=end;
		while(now!=start)//逐个遍历路径
		{
			pre=path[now];//前一跳
			map[pre][now]-=step;//减少流
			map[now][pre]+=step;//增加反向流
			now=pre;
		}
	}
	return max_flow;
}
int main(void)
{
    register int i;
    int u,v,w;
    while(scanf("%d%d",&n,&m)!=EOF)
    {
        memset(map,0,sizeof(map));
        for(i=0;i<n;i++)
        {
            scanf("%d%d%d",&u,&v,&w);
            map[u][v]+=w;
        }
        start=1,iend=m;
        printf("%d\n",EK());
    }
    return 0;
}
