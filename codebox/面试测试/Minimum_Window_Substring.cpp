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
