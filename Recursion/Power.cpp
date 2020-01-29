#include <iostream>
using namespace std;
int power(int x,int n){
    if(n == 1){
        return x;
    }
    return x * power(x,n-1);
}
int main() {
    int x,n;
    cin >> x >> n;
    int ans = power(x,n);
    cout << ans << endl;
}
