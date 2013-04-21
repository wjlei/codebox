int g_nstatus=kvalid;
int strtoint(const char *str){
	g_nstatus=kinvalid;
	long long num=0;
	int i=0;
	if(str!=NULL&&str[i]!='\0'){
		bool minus =false;
		if(str[i]=='+')//注意符号
			i++;
		else if(str[i]=='-'){
			i++;
			minus=true;
		}
		if(str[i]!='\0'){//注意只有'+'和'-'
			while(str[i]!='\0'){
				if(str[i]>='0'&&str[i]<='9'){//注意数字有效
					num=num*10+str[i]-'0';
					if(num>0x7fffffff){//注意溢出
						num=0;
						break;
					}
					i++;
				}
				else{
					num=0;
					break;
				}
			}
			if(str[i]=='\0'){//检查是否遍历完
				if(minus)
					num=-num;
				g_nstatus=kvalid;
			}
		}
	}
	return (int)num;
}