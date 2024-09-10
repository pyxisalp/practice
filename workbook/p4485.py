import sys, heapq
inf = sys.maxsize
input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

t = 0
while True:
    n = int(input())
    if n == 0:
        break
    t += 1

    graph = [list(map(int, input().split())) for _ in range(n)]
    distance = [[inf] * n for _ in range(n)]

    heap = []
    heapq.heappush(heap, (graph[0][0], 0, 0))

    while heap:
        before, x, y = heapq.heappop(heap)

        if x == n - 1 and y == n - 1:
            print(f'Problem {t}: {before}')

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n:
                after = before + graph[nx][ny]

                if after < distance[nx][ny]:
                    distance[nx][ny] = after
                    heapq.heappush(heap, (after, nx, ny))

