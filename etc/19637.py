import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = []
for _ in range(n):
    name, limit = input().split()
    arr.append([int(limit), name])
for _ in range(m):
    status = int(input())
    i = 0
    j = n - 1
    idx = 0
    while i <= j:
        mid = (i + j) // 2
        if status <= arr[mid][0]: 
            j = mid - 1
            idx = mid
        else: 
            i = mid + 1
    print(arr[idx][1])