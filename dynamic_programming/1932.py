import sys
input = sys.stdin.readline

n = int(input())
dp = [list(map(int, input().split())) for _ in range(n)]

for i in range(1, n):
    for j in range(i + 1):
        temp = 0
        if j - 1 >= 0:
            temp = dp[i - 1][j - 1]
        if j < i:
            temp = max(temp, dp[i - 1][j])
        dp[i][j] += temp

print(max(dp[n - 1]))

