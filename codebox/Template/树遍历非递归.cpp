void PreOrderUnrec(Bitree p){
	if(p==NULL)
		return;
	Stack s;
	while (p!=null || !StackEmpty(s)){
		while (p!=null){           //遍历左子树
			visite(p->data);
			push(s,p);
			p=p->lchild;       
		}//endwhile
		if (!StackEmpty(s)){         //通过下一次循环中的内嵌while实现右子树遍历
			p=pop(s);
			p=p->rchild;        
		}//endif
	}//endwhile 
}//PreOrderUnrec
2.中序遍历非递归算法
void InOrderUnrec(Bitree p){
	if(p==NULL)
		return;
	Stack s;
	while (p!=null || !StackEmpty(s)){
		while (p!=null){           //遍历左子树
			push(s,p);
			p=p->lchild;
		}//endwhile
		if (!StackEmpty(s)){
			p=pop(s);
			visite(p->data);        //访问根结点
			p=p->rchild;            //通过下一次循环实现右子树遍历
		}//endif   
	}//endwhile
}//InOrderUnrec
3.后序遍历非递归算法
#define maxsize 100
typedef enum{L,R} tagtype;
typedef struct{
	Bitree p;
	tagtype tag;
}stacknode;
void PostOrderUnrec(Bitree p){
	if(p==NULL)
		return;
	Stack s;
	do {
		while (p!=null){        //遍历左子树
			x.ptr = p; 
			x.tag = L;         //标记为左子树
			push(s,x);
			p=p->lchild;
		}
		while (!StackEmpty(s) && s.Elem[s.top].tag==R){
			x = pop(s);
			p = x.ptr;
			visite(p->data);   //tag为R，表示右子树访问完毕，故访问根结点       
		}
		if (!StackEmpty(s)){
			s.Elem[s.top].tag =R;     //遍历右子树
			p=s.Elem[s.top].ptr->rchild;        
		}    
	}while (!StackEmpty(s));
}//PostOrderUnrec
//原始
void midsearch(node *root){
	if(root==NULL)
		return ;
	stack<node*> st;
	st.push(root);
	while(st.size()>0){
		while(root->left!=NULL){
			st.push(root->left);
			root=root->left;
		}
		while(st.size()>0){
			root=st.top();
			st.pop();
			cout<<root->m<<" ";
			if(root->right!=NULL){
				root=root->right;
				st.push(root);
				break;
			}
		}
	}
}

