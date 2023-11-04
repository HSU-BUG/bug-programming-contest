def search(start, end, target):
    min_time = 0
    while start <= end:
        mid = (start + end) // 2
        if sum(map(lambda x: mid//x, mcdonald)) >= target:
            min_time = mid
            end = mid - 1
        else:
            start = mid + 1
    return min_time


n, m = map(int, input().split())
mcdonald = list(map(int, input().split()))
print(search(0, int(1e12), m//5000))