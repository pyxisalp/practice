import sys
input = sys.stdin.readline

n = int(input())
off = list(map(bool, map(int, input().rstrip())))
target = list(map(bool, map(int, input().rstrip())))

on = off.copy()

cnt = 0

for i in range(1, n):
    if off[i - 1] != target[i - 1]:
        cnt += 1
        off[i - 1] = not off[i - 1]
        off[i] = not off[i]
        if i != n - 1:
            off[i + 1] = not off[i + 1]

if ''.join(map(str, off)) == ''.join(map(str, target)):
    print(cnt)
    exit()

on[0] = not on[0]
on[1] = not on[1]

cnt = 1

for i in range(1, n):
    if on[i - 1] != target[i - 1]:
        cnt += 1
        on[i - 1] = not on[i - 1]
        on[i] = not on[i]
        if i != n - 1:
            on[i + 1] = not on[i + 1]

if ''.join(map(str, on)) == ''.join(map(str, target)):
    print(cnt)
else:
    print(-1)