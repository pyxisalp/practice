import sys, heapq
input = sys.stdin.readline
inf = sys.maxsize

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
q = []
result = [inf] * (n + 1)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

for i in range(1, n + 1):
    graph[i].sort(key=lambda x: x[1])

heapq.heappush(q, (0, 1))

while q:
    d, x = heapq.heappop(q)

    if result[x] < d:
        continue

    for i in graph[x]:
        nd = d + i[1]

        if nd < result[i[0]]:
            result[i[0]] = nd
            heapq.heappush(q, (nd, i[0]))

print(result[n])