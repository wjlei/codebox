package main;

public class Minimum_Window_Substring {
    public String minWindow(String S, String T) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
          int need[] =new  int[256];
  for(int i = 0; i < T.length(); i++)
    need[T.charAt(i)]++;
  int found[] = new int[256];
  int count = 0;
  int minLen = S.length()+1;
  int minBegin = 0;
  for(int begin = 0, end = 0; end < S.length(); ++end){
    char ch = S.charAt(end);
    if(need[ch] == 0) continue;
    if(++found[ch] <= need[ch]) count++;
    if(count == T.length()){//只要一次即可
      while(need[S.charAt(begin)] == 0||found[S.charAt(begin)] > need[S.charAt(begin)]){//begin只有满足begin和end之间有多余s[begin]时移动
	if(found[S.charAt(begin)] > need[S.charAt(begin)])
	  found[S.charAt(begin)]--;
	begin++;
      }
      int leng = end - begin + 1;
      if(leng < minLen){
	minLen = leng;
	minBegin = begin;
      }
    }
  }
  return minLen > S.length()?"":S.substring(minBegin, minLen+minBegin);
    }

}
