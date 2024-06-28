import sys
input = sys.stdin.readline

n, m = map(int, input().split())
cost = [list(map(int, input().split())) for _ in range(n)]

global result
result = 600

def dfs(i, j, prev_dir, curr):
    global result

    if i == n - 1:
        result = min(result, curr)
        return

    if prev_dir != 1 and j - 1 >= 0:
        dfs(i + 1, j - 1, 1, curr + cost[i + 1][j - 1])
    if prev_dir != 2:
        dfs(i + 1, j, 2, curr + cost[i + 1][j])
    if prev_dir != 3 and j + 1 < m:
        dfs(i + 1, j + 1, 3, curr + cost[i + 1][j + 1])

for j in range(m): 
    dfs(0, j, 0, cost[0][j])

print(result)