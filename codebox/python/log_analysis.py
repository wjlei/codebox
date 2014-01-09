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

#file='/Users/wjlei/testdata/log/sample'
def analisysfile(file):
    input = open(file,'r')
    output = open(file.split('.')[0]+'_result.log','w')
    dic={}
    try :
        for line in input:
            if line.find('serialNumber')!=-1:
                if re.search('serialNumber *:* *(\d+)',line)==None:
                    continue;
                sn=re.search('serialNumber *:* *(\d+)',line).group(1);
                #ts=datetime.datetime.strptime('2013-11-06 15:00:18.429','%Y-%m-%d %H:%M:%S.%f')
                #print(ts.strftime('%Y-%m-%d %H:%M:%S.%f'))
                ts=datetime.datetime.strptime(re.search('(\d+-*)+ (\d+:*)+.\d+',line).group(0),'%Y-%m-%d %H:%M:%S.%f');
                if line.find('Received an event')!=-1:
                    a=Aline();
                    a.sn=int(sn);a.rts=ts;a.rline=line;
                    dic[int(sn)]=a;
                elif line.find('EventEmitter')!=-1:
                    if dic.has_key(int(sn)):
                        a=dic[int(sn)];
                        a.sts=ts;a.sline=line;
                    else:
                        a=Aline();
                        a.sn=int(sn);a.sts=ts;a.sline=line;
                        dic[int(sn)]=a;
        for i in range(0,len(dic)-1):
            if(dic[i].rline!=None):
                output.write(dic[i].rline);
            else:
                output.write('missing\n');
            if(dic[i].sline!=None):
                output.write(dic[i].sline);
            else:
                output.write('missing\n');
        sum=0;
        count=0;
        for i in range(0,len(dic)-1):
            if dic[i].sts!=None and dic[i].rts!=None:
                sum+=(dic[i].sts-dic[i].rts).microseconds;
                count+=1;
        if(count!=0):
            print(sum/count)
        else:
            print('None');
    finally:
        input.close();
        output.close();
        print('processing');

logdir='D:\\INAS\\log';
filelist=os.listdir(logdir);
today=time.strftime('%Y%m%d',time.localtime(time.time()));
#today='20131106';
for filename in filelist:
    if filename.find(today)!=-1 and filename.find('result')==-1:
        analisysfile(logdir+'/'+filename);
print('done');
    

