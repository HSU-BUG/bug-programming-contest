import sys
input = sys.stdin.readline

n, k = map(int, input().split())
dominos = sorted([int(input()) for _ in range(n)])

result = 0
for i in range(n):
    count = 0
    for j in range(n):
        if dominos[j] >= dominos[i] and dominos[j] <= dominos[i] + k:
            count += 1
    result = max(result, count)

print(result)