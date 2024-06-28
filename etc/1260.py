import sys
input = sys.stdin.readline
from collections import deque

n, m, v = map(int, input().split())
graph = [[0] * (n + 1) for __ in range(n + 1)]
for _ in range(m):
    i, j = map(int, input().split())
    graph[i][j] = 1
    graph[j][i] = 1

def dfs(start, visited):
    print(start, end=' ')
    visited[start] = 1
    for i in range(1, n + 1):
        if not visited[i] and graph[start][i] == 1:
            dfs(i, visited)

def bfs(start, visited):
    q = deque([start])
    visited[start] = 1
    while q:
        i = q.popleft()
        print(i, end=' ')
        for j in range(1, n + 1):
            if not visited[j] and graph[i][j] == 1:
                q.append(j)
                visited[j] = 1

dfs(v, visited = [0] * (n + 1))
print()

bfs(v, visited = [0] * (n + 1))
print()