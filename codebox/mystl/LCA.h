Node *LCA(Node *root, Node *p, Node *q) {
if (!root) return NULL;//!
if (root == p || root == q) return root;//!
Node *L = LCA(root->left, p, q);
Node *R = LCA(root->right, p, q);
if (L && R) return root;
return L ? L : R;
}