import sys
from math import factorial
input = sys.stdin.readline


def combi(n, r):
    if n < r:
        return 0
    return factorial(n) // factorial(r) // factorial(n-r)


a, b = map(int, input().split())
result = combi(a + b, 3) - combi(a, 3) - combi(b, 3)
print(result)