#include<iostream>
#include<string>
#include<stack>
using namespace std;
int main()
{
	string ss;
	cin >> ss;
	stack < string > st;
	string temp;
	int isword = 1;
	for (int i = 0; i < ss.size(); i++)
	{
		if (ss[i] == '#')
		{
			if (temp.size() > 0)
			{
				if (isword)
				{
					st.push(temp);
					temp = "";
				}
				else
				{
					string rev;
					for (int i = temp.size() - 1; i >= 0; i--)
						rev+=(temp[i]);
					st.push(rev);
					temp = "";
				}

			}
			st.push("#");
			continue;
		}
		if (temp.size() == 0)
		{
			if ((ss[i] >= 'a' && ss[i] <= 'z')
				|| (ss[i] >= 'A' && ss[i] <= 'Z'))
				isword = 1;
			else
				isword = 0;
		}
		temp+=(ss[i]);
	}
	if(temp.size()>0)
	st.push(temp);
	while (st.size() > 0)
	{
		cout << st.top();
		st.pop();
	}
	cout << endl;
	return 1;
}