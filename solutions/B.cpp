#include <iostream>
using namespace std;

int combi(int n) {
    int result = 1;
    if (n < 3) {
        return 0;
    }
    for (int i = n; i > n - 3; i--) {
        result *= i;
	    }
    return result / 6;
}

int main(void) {
    cin.tie(0)->sync_with_stdio(0);
    int a, b;
    cin >> a >> b;
    cout << combi(a + b) - combi(a) - combi(b);
}