import sys
input = sys.stdin.readline

n = int(input())
distance = list(map(int, input().split()))
cost = list(map(int, input().split()))

curr_cost = cost[0]
total_cost = 0
for i in range(n - 1):
    curr_cost = min(curr_cost, cost[i])
    total_cost += curr_cost * distance[i]

print(total_cost)