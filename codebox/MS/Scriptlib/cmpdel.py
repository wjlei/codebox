import os,os.path

for root,subdirs,files in os.walk("/home/jiweng/Downloads"):
    newroot = root.replace("/Downloads", "/localdownload")
    for subdir in subdirs:
        if not os.path.exists(os.path.join(newroot,subdir)):
           os.mkdir(os.path.join(newroot,subdir))
    for filepath in files:    
        os.rename(os.path.join(root,filepath), os.path.join(newroot,filepath))
