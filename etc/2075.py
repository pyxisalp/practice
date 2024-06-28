import sys, heapq
input = sys.stdin.readline

n = int(input())
heap = []
for _ in range(n): 
    row = list(map(int, input().split()))
    for entry in row:
        if len(heap) < n:
            heapq.heappush(heap, entry)
        else:
            if entry > heap[0]:
                heapq.heappop(heap)
                heapq.heappush(heap, entry)
print(heap[0])

