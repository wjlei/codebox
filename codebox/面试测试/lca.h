node *LCA(node *root, node *p, node *q) {
  if (!root) return NULL;
  if (root == p || root == q) return root;//对于q和p有一个是父节点时，直接返回父节点，忽略另一个节点
  node *L = LCA(root->left, p, q);
  node *R = LCA(root->right, p, q);
  if (L && R) return root;
  return L ? L : R;
}
