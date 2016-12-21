# -*- coding: utf-8 -*-
'''
Created on 2013?11?13?

@author: wjlei
'''
import os,sys
import re
import time
import datetime

basetime=time.strptime("1/12/2015 18:18:00", "%m/%d/%Y %H:%M:%S");
filename='C:\\Users\\jiweng\\Desktop\\Logs\\ZodiacLauncher_45871.log';

def analisysfile(file):
    print(file);
    input = open(file,'r')
    output = open(file.split('.')[0]+'_result.log','w')
    dic={}
    try :
        for line in input:
            ts=time.strptime(line.split(',')[1],"%m/%d/%Y %H:%M:%S");
            if ts<basetime:
                continue;
            if line.find('http://localhost:5050')!=-1:
                continue;
            if line.find('task queue ActionBlock')!=-1:
                continue;
            if line.find('zk client tryconnect socket')!=-1:
                continue;
            if line.find('ExceptionInformation')!=-1:
                continue;
            if line.find('CO3SCH010195022')==-1:
                continue;
            if line.find('PingMessage')==-1&line.find('PongMessage')==-1:
                output.write(line);
    finally:
        input.close();
        output.close();
        print('processing');

logdir='C:\\Users\\jiweng\\Desktop\\Logs';
filelist=os.listdir(logdir);
today=time.strftime('%Y%m%d',time.localtime(time.time()));
#today='20131106';
for filename in filelist:
    if filename.find('result')==-1 and filename.find('log')!=-1:
        analisysfile(logdir+'/'+filename);
print('done');
