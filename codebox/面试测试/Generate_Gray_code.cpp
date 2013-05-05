void generateGrayCode(vector<string>& ret,
	string& s, int i, int n){
		if(i==n){
			ret.push_back(s);
		}else{
			generateGrayCode(ret,s,i+1,n);
			if(s[i]=='0') s[i]='1';
			else s[i]='0';
			generateGrayCode(ret,s,i+1,n);
		}
}
 //          r
//	      /    \
//       0      1
//     /  \    / \
//    0   1   1   0
//   / \ / \ / \ / \
//  0  1 1 0 0 1 1  0
//深度优先遍历