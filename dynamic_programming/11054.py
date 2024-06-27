import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
left = [1] * n
right = [1] * n

for i in range(n):
    for j in range(i):
        if a[i] > a[j]:
            left[i] = max(left[i], left[j] + 1)

a.reverse()
for i in range(n):
    for j in range(i):
        if a[i] > a[j]:
            right[i] = max(right[i], right[j] + 1)

right.reverse()
M = 0
for i in range(n):
    M = max(M, left[i] + right[i] - 1)

print(M)