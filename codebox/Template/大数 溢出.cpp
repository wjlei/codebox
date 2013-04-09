sum2=sum1;
for(int day=0;;day++){
	if(sum1>k){
		printf("Case #%d: %d\n",++l,day);
		break;
	}
	sum2=sum1;
	sum1=sum2*(k1+k2);
	if((sum2 >0 &&(k1+k2)>0 && sum1 <0))//Òç³ö 
	{
		printf("Case #%d: %d\n",++l,day+1);
		break;
	}

	if((sum2 <0 &&(k1+k2)<0 && sum1 <0))//Òç³ö 
	{
		printf("Case #%d: %d\n",++l,day+1);
		break;
	}
	if(day>100000){
		printf("Case #%d: inf\n",++l);
		break;
	}
}