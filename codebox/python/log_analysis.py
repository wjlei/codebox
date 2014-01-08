# -*- coding: utf-8 -*-
'''
Created on 2013年11月13日

@author: wjlei
'''
import os,sys
import re
import time
import datetime

class Aline:
    def __init__(self, sn=None, rts=None,rline=None,sts=None,sline=None):
        self.sn = sn
        self.rts = rts
        self.sts=sts
        self.rline = rline
        self.sline=sline

list=os.listdir('/Users/wjlei/testdata/log');
for file in list:
    print(file);

file='/Users/wjlei/testdata/log/sample'

input = open(file+'.log','r')
output = open(file+'_result.log','w')
dic={}
try :
    for line in input:
        if line.find('serialNumber')!=-1:
            sn=re.search('serialNumber *: *(\d)',line).group(1);
            #ts=datetime.datetime.strptime('2013-11-06 15:00:18.429','%Y-%m-%d %H:%M:%S.%f')
            #print(ts.strftime('%Y-%m-%d %H:%M:%S.%f'))
            ts=datetime.datetime.strptime(re.search('(\d+-*)+ (\d+:*)+.\d+',line).group(0),'%Y-%m-%d %H:%M:%S.%f');
            if line.find('Recieve')!=-1:
                a=Aline();
                a.sn=int(sn);a.rts=ts;a.rline=line;
                dic[int(sn)]=a;
            elif line.find('EmitEvent')!=-1:
                a=dic[int(sn)];
                a.sts=ts;a.sline=line;
            output.write(line)
    sum=0;
    count=0;
    for i in range(0,len(dic)-1):
        if dic[i].sts!=None and dic[i].rts!=None:
            sum+=(dic[i].sts-dic[i].rts).microseconds;
            print(sum);
            count+=1;
    print(sum/count)
finally:
    input.close()
    output.close()
    print('done')