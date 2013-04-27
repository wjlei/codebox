  //1 2 3 4 5 6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21  22
  //1,2,4,5,8,10,12,17,19,25,25,36,40,45,56,65,67,75,80,99,100,101
  int a[]={1,4,5,10,12,17,25,45,67,100};
  int b[]={2,8,19,25,36,40,56,65,75,80,99,101};

//二分查找树
 node node1(1),node2(2),node3(3),node4(4),node5(5),node6(6),node7(7),node8(8),node9(9),node10(10),node11(11),node12(12),node13(13),node14(14),node15(15);
  node8.left=&node4;node8.right=&node12;
  node4.left=&node2;node4.right=&node6;node12.left=&node10;node12.right=&node14;
  node2.left=&node1;node2.right=&node3;node6.left=&node5;node6.right=&node7;node10.left=&node9;node10.right=&node11;node14.left=&node13;node14.right=&node15;
  cout<<findtheshortest(&node8,&node3,&node10)<<endl;
