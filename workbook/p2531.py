import sys
input = sys.stdin.readline

n, d, k, c = map(int, input().split())
arr = []
result = 0

for _ in range(n):
    arr.append(int(input()))

for i in range(n):
    if i + k >= n:
        temp = set(arr[i:n] + arr[:k - n + i] + [c])
    else:
        temp = set(arr[i:i + k] + [c])
    
    cnt = len(temp)
    result = max(result, cnt)

print(result)