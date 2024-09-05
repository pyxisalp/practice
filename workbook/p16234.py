import sys
from collections import deque
input = sys.stdin.readline

n, l, r = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]

flag = True
result = 0
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

while flag:
    flag = False
    visited = [[False] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                q = deque([(i, j)])
                visited[i][j] = True

                arr = [(i, j)]
                cnt = 1
                total = a[i][j]

                while q:
                    x, y = q.popleft()

                    for k in range(4):
                        nx = x + dx[k]
                        ny = y + dy[k]

                        if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                            if l <= abs(a[nx][ny] - a[x][y]) <= r:
                                flag = True

                                q.append((nx, ny))
                                visited[nx][ny] = True

                                arr.append((nx, ny))
                                cnt += 1
                                total += a[nx][ny]

                val = int(total / cnt)
                for x, y in arr:
                    a[x][y] = val
        
    if flag:        
        result += 1

print(result)



