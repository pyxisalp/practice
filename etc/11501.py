import sys
input = sys.stdin.readline

t  = int(input())
for _ in range(t):
    n = int(input())
    price = list(map(int, input().split()))
    profit = 0
    maxPrice = 0
    for i in range(n - 1, -1, -1):
        if price[i] > maxPrice:
            maxPrice = price[i]
        else:
            profit += maxPrice - price[i]
    print(profit)

# 뒤에서부터 탐색하는 방법도 고려해야겠다.