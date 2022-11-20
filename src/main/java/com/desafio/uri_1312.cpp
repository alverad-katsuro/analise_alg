/// David Mateus Batista <david.batista3010@gmail.com>
/// Computer Science - Federal University of Itajuba - Brazil

#include <bits/stdc++.h>

using namespace std;


enum {North, East, South, West};




int main()
{
	const int MN=1e+3+35;
	int n, k;
	int data[MN][MN];
	int sum[MN][MN];
	int dp[MN][MN][2];
	while(scanf("%d", &n) && n)
	{
		for(int i=1; i<=n; i++)
			for(int j=1; j<=i; j++)
				scanf("%d", &data[i][j]);

		for(int i=1; i<=n; i++)
			for(int j=1; j<=i; j++)
				sum[i][j]=(sum[i-1][j]+sum[i-1][j-1]-(i-2>=0?sum[i-2][j-1]:0))+data[i][j];

		int ans=0;
		for(int i=1; i<=n; i++)
			for(int j=1; j<=n; j++)
				dp[i][j][0]=dp[i][j][1]=0;

		for(int j=1; j<=n; j++)
		{
			for(int i=j; i<=n; i++)
			{
				dp[i][j][0]=sum[i][j];
				dp[i][j][0]=max(dp[i][j][0], dp[i-1][j-1][1]+(sum[i][j]-sum[i-1][j-1]));
				ans=max(ans, dp[i][j][0]);
			}
			dp[n][j][1]=dp[n][j][0];
			for(int i=n-1; i>=j; i--)
				dp[i][j][1]=max(dp[i+1][j][1], dp[i][j][0]);
		}
		printf("%d\n", ans);
	}
	return 0;
}