import sys
input = sys.stdin.readline

n = int(input())
dp = [0] * (n + 1)

for i in range(2, n + 1):
    temp = dp[i - 1]
    if i % 3 == 0:
        temp = min(temp, dp[i // 3])
    if i % 2 == 0:
        temp = min(temp, dp[i // 2])
    dp[i] = 1 + temp

print(dp[n])