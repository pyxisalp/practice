import sys
input = sys.stdin.readline
from collections import deque

n, m = map(int, input().split())
arr = []
visited = [[-1] * m for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
for _ in range(n): arr.append(list(map(int, input().split())))

def bfs(startRow, startCol):
    q = deque([(startRow, startCol)])
    visited[startRow][startCol] = 0
    while q:
        currRow, currCol = q.popleft()
        for i in range(4):
            nextRow = currRow + dx[i]
            nextCol = currCol + dy[i]
            if 0 <= nextRow < n and 0 <= nextCol < m and visited[nextRow][nextCol] == -1:
                if arr[nextRow][nextCol] == 0:
                    visited[nextRow][nextCol] = 0
                elif arr[nextRow][nextCol] == 1:
                    visited[nextRow][nextCol] = visited[currRow][currCol] + 1
                    q.append((nextRow, nextCol))

for i in range(n):
    for j in range(m):
        if arr[i][j] == 2:
            bfs(i,j)

for i in range(n):
    for j in range(m):
        if arr[i][j] == 0: print(0, end=' ')
        else: print(visited[i][j], end=' ')
    print()