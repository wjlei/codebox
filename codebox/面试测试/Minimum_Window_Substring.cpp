package prepare;

//find min length of num, contain target
public class find_min_segement_contain_target {
	
 static	int findminsegement(int num[],int target[]){
		int need[]=new int[256];
		int cur[]=new int[256];
		for(int i=0;i<target.length;i++){
			need[target[i]]++;
		}
		int left=0;int length=0;int min=Integer.MAX_VALUE;
		for(int right=0;right<num.length;right++){
			if(cur[num[right]]<need[num[right]])
				length++;
			cur[num[right]]++;
			while(cur[num[left]]-1>=need[num[left]]){
				cur[num[left]]--;
				left++;
			}
			if(length==target.length)
				min=Math.min(min, right-left+1);
		}
		return min;
		
	}
	public static void main(String args[]) {
		int a[]={1,2,3,1,1,2,4,1};
		int b[]={1,2,3,4};
		System.out.print(findminsegement(a,b));
		
	}

}






string minWindow(string S, string T) {
  int need[256] = {0};
  for(int i = 0; i < T.size(); i++)
    need[T[i]]++;
  int found[256] = {0};
  int count = 0;
  int minLen = S.size()+1;
  int minBegin = 0;
  for(int begin = 0, end = 0; end < S.size(); ++end){
    char ch = S[end];
    if(need[ch] == 0) continue;
    if(++found[ch] <= need[ch]) count++;
    if(count == T.size()){//只要一次即可
      while(need[S[begin]] == 0||found[S[begin]] > need[S[begin]]){//begin只有满足begin和end之间有多余s[begin]时移动
	if(found[S[begin]] > need[S[begin]])
	  found[S[begin]]--;
	begin++;
      }
      int leng = end - begin + 1;
      if(leng < minLen){
	minLen = leng;
	minBegin = begin;
      }
    }
  }
  return minLen > S.size()?"":S.substr(minBegin,minLen);
}
