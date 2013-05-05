vector<vector<string>> ret;
int a[100];//第i行选取第几列
bool canUse[100];
bool check(int y, int n){//检查斜线冲突，行的间隔与列的间隔不能相等，相等则冲突
	for(int i = 0; i < n; i++)
		if (abs(i - n) == abs(y - a[i]))
			return false;
	return true;
}
void solve(int dep, int maxDep){
	if (dep == maxDep){//输出
		vector<string> ans;
		for(int i = 0; i < maxDep; i++){
			string s;
			for(int j = 0; j < a[i]; j++)
				s += '.';
			s += 'Q';
			for(int j = 0; j < maxDep - (a[i] + 1); j++)
				s += '.';
			ans.push_back(s);
		}
		ret.push_back(ans);
		return;
	}
	//canUse[i]保证行列不冲突
	for(int i = 0; i < maxDep; i++)
		if (canUse[i] && check(i, dep)){
			canUse[i] = false;
			a[dep] = i;
			solve(dep + 1, maxDep);
			canUse[i] = true;
		}
}