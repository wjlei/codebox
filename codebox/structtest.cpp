struct {
  int a;
  int b;
}*c;
struct {
  int d;
  char j;
}f;
int main(){
  c=&f;
  return 1;
}
