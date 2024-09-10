import sys
input = sys.stdin.readline

r, c = map(int, input().split())
arr = [input().rstrip() for _ in range(r)]

answer = 0
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
mark = [False] * 26

def dfs(x, y, length):
    global answer

    mark[ord(arr[x][y]) - ord('A')] = True
    answer = max(answer, length)

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < r and 0 <= ny < c:
            if not mark[ord(arr[nx][ny]) - ord('A')]:
                dfs(nx, ny, length + 1)
                mark[ord(arr[nx][ny]) - ord('A')] = False

dfs(0, 0, 1)

print(answer)
