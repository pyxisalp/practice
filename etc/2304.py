import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    l, h = map(int, input().split())
    arr.append((l, h))
arr.sort(key=lambda x: x[0])
maxHeight = 0
maxIdx = 0
for i in range(n):
    if arr[i][1] > maxHeight:
        maxIdx = i
        maxHeight = arr[i][1]

area = maxHeight
height = arr[0][1]
for i in range(maxIdx):
    area += height * (arr[i + 1][0] - arr[i][0])
    if arr[i + 1][1] > height: height = arr[i + 1][1]

height = arr[-1][1]
for i in range(n - 1, maxIdx, -1):
    area += height * (arr[i][0] - arr[i - 1][0])
    if arr[i - 1][1] > height: height = arr[i - 1][1]

print(area)