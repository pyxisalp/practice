import sys
input = sys.stdin.readline

n = int(input())
cost = list(map(int, input().split()))
m = int(input())

cost.sort()

if sum(cost) <= m: print(max(cost))
else:
    start = 0
    end = max(cost)
    ans = 0

    while start <= end:
        mid = (start + end) // 2
        total_cost = 0

        for i in cost: total_cost += min(i, mid)

        if total_cost > m: end = mid - 1
        else: start = mid + 1

    print(end)
