import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

low = 0
high = n - 1
l = h = -1
M = 2000000000

while low < high:
    x = arr[low] + arr[high]

    if abs(x) < M:
        M = abs(x)
        l = arr[low]
        h = arr[high]

    if x > 0:
        high -= 1
    else:
        low += 1

print(l, h)