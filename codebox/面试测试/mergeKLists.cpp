typedef struct ListNode{
  int val;
  struct ListNode*next;
}ListNode;
class comp {
public:
  bool operator()(const ListNode* l,const ListNode* r)const
  {
    return (l->val > r->val);
  }
};
ListNode *mergeKLists(vector<ListNode *>&lists) {
  vector<ListNode*>::iterator it = lists.begin();
  while(it != lists.end()) {
    if(*it == NULL) lists.erase(it);
    else ++it;
  }
  if(lists.size() < 1) return NULL;
  ListNode *head = NULL, *cur = NULL;
  make_heap(lists.begin(), lists.end(), comp());//对k个链表头排序
  while(lists.size() > 0) {
    if(head == NULL){
      head = cur = lists[0];
      cout<<lists[0]->val<<endl;
    }
    else{
      cur = cur->next = lists[0];
      cout<<lists[0]->val<<endl;
    }
    pop_heap(lists.begin(), lists.end(), comp());//最小值放到数组最后
    int last = lists.size() - 1;
    if(lists[last]->next != NULL) {
      lists[last] = lists[last]->next;//在尾部加入,最小的更新下一跳
      push_heap(lists.begin(), lists.end(), comp());//在尾部加入，后调整
    }
    else 
      lists.pop_back();
  }
  return head;
}
