import sys, heapq
input = sys.stdin.readline
INF = sys.maxsize

n, d = map(int, input().split())
dp = [INF] * (d + 1)
graph = [[] for _ in range(d + 1)]

def dijkstra(start):
    q = []
    heapq.heappush(q, (start, 0))
    dp[start] = 0

    while q:
        i, cost = heapq.heappop(q)

        if cost > dp[i]: continue

        for j in graph[i]:
            nCost = cost + j[1]
            if nCost < dp[j[0]]:
                dp[j[0]] = nCost
                heapq.heappush(q, (j[0], nCost))

for i in range(d):
    graph[i].append((i + 1, 1))

for _ in range(n):
    i, j, cost = map(int, input().split())
    if i <= d and j <= d and i < j:
        graph[i].append((j, cost))

dijkstra(0)

print(dp[d])
