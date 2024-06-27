import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
num = list(map(int, input().split()))
q = deque([])
for i in range(n):
    q.append((i + 1, num[i]))
result = []

while q:
    x, cnt = q.popleft()
    result.append(x)

    if cnt > 0:
        q.rotate(-cnt + 1)
    elif cnt < 0:
        q.rotate(-cnt)

print(' '.join(map(str, result)))


