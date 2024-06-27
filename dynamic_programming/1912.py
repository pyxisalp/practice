import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

for i in range(n):
    arr[i] = max(arr[i], arr[i] + arr[i - 1])

print(max(arr))

