import sys, heapq
input = sys.stdin.readline

n = int(input())
heap = []
for _ in range(n):
    x = int(input())
    if x: heapq.heappush(heap, x)
    else:
        try: print(heapq.heappop(heap))
        except: print(0)