import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())
q = deque(list(range(1, n + 1)))
result = []

cnt = 0
while q:
    cnt += 1
    x = q.popleft()

    if cnt == k:
        result.append(x)
        cnt = 0
    else:
        q.append(x)

result = '<' + str(result).strip('[]') + '>'
print(result)