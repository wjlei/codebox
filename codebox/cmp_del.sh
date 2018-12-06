#!/bin/sh
function cmp_del() { 
    if [ -f "$1" ] && [ -f "$2" ]; then 
       diff -q "$1" "$2"
       if [ $? -eq 0 ]; then 
          rm -f "$2"
       fi
    elif [ -d "$1" ] && [ -d "$2" ]; then 
       local SUBFILES=`ls "$1"/` 
       for SUBF in $SUBFILES 
       do 
         cmp_del "$1/$SUBF" "$2/$SUBF" 
       done
    fi
} 
cp -R /home/jiweng/Downloads /home/jiweng/localdownload
cmp_del /home/jiweng/localdownload/Downloads /home/jiweng/Downloads
