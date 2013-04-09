//同系不相邻 座位不相邻
#include<iostream>
#include<stdio.h>
#include<stdlib.h>
#include <string.h>
using namespace std;
#define MOD 1000000007 
long long dp[50][450];//50 为组数  450 表示最大的违例数字，即相邻为同一组的不合法个数
long long a[50];  
long long c[450][450];
void init(){  

    for( int i=0; i<450; ++i ){  
        c[i][0] = c[i][i] = 1;  
    }  

    for( int i=1; i<450; ++i ){  
        for( int j=1; j<i; ++j ){  
            c[i][j] = c[i-1][j-1] + c[i-1][j];  
            if( c[i][j] >= MOD )  
                c[i][j] -= MOD;  
        }  
    }  

    a[0] = 1;  
    for( int i=1; i<50; ++i )  
        a[i] = a[i-1] * i % MOD;  
}  
int main(){
#ifdef _DEBUG
    freopen("data","r",stdin);
#endif
    init();
    int T;
    int cas=0;
    cin>>T;
    while(T--){
        memset(dp,0,sizeof(dp));
        long long sumhole=1;//0个人时，空隙数为1
        long long A=1;
        dp[0][0]=1;//0人时，只有一个排法，且违例为0
        int n;
        scanf("%d",&n);
        for(int i=0;i<n;i++){
            int x;
            scanf("%d",&x);
            for(int y=0;y<450;y++){//违例数为y个的dp
                if(dp[i][y]>0){
                    for(int j=1;j<=x;j++){//构造组数
                        for(int k=0;k<=j&&k<=y;k++){//选择k组去插i个违例，消除k个违例
                            long long temp=c[x-1][j-1]%MOD*c[y][k]%MOD*c[sumhole-y][j-k]%MOD;
							           //x个数能构造出j个组的个数  从y个违例选择k个消除  将剩下的j-k组插入到非违例的孔中的个数
                            dp[i+1][y-k+x-j]+=dp[i][y]*temp%MOD;
							//y-k减少的违例，由于x选j组又多出来x-j个违例
                            dp[i+1][y-k+x-j]%=MOD;
                        }}
                }
            }
            sumhole+=x;//总空隙增加
            A=A*a[x]%MOD;//组内自排序
        }
        printf( "Case %d: %lld\n", ++cas, dp[n][0]*A %MOD );
    }
#ifdef _DEBUG
    freopen("CON","r",stdin);
    system("pause");
#endif
    return 1;
}
