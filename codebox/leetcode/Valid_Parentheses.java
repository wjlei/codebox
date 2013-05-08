package test;

import java.util.Stack;

public class Valid_Parentheses {
    public static void main(String[] args) {
	String ss="{}][}}{[))){}{}){(}]))})[({";
	System.out.println(isValid(ss) );

    }

    public static boolean isValid(String s) {
	int n = s.length();
	char cs[] = s.toCharArray();
	char kk = 'f';
	Stack<Character> s1 = new Stack<Character>();
	for (int i = 0; i < n; i++) {
	    if (cs[i] == '(' || cs[i] == '[' || cs[i] == '{')
		s1.push(cs[i]);
	    else {
		if (cs[i] == ')') {
		    if (s1.size()>0&&s1.peek() == '(') {
			s1.pop();
		    }
		    else
			return false;
		}
		else if (cs[i] == ']') {
		    if (s1.size()>0&&s1.peek() == '[') {
			s1.pop();
		    }
		    else
			return false;
		}
		else if (cs[i] == '}') {
		    if (s1.size()>0&&s1.peek() == '{') {
			s1.pop();
		    }
		    else
			return false;
		}
	    }
	}
	if(s1.size()!=0)
	    return false;
	else
	    return true;
    }
}
