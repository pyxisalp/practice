import sys
input = sys.stdin.readline

n, s = map(int, input().split())
arr = [0] + list(map(int, input().split()))
dp = [0] * (n + 1)

for i in range(1, n + 1):
    dp[i] = arr[i] + dp[i - 1]

l = 1
r = 1
answer = n + 1
while l <= r <= n:
    temp = dp[r] - dp[l - 1]
    length = r - l + 1

    if temp >= s:
        l += 1
        answer = min(answer, length)
    else:
        r += 1

print(answer if answer != n + 1 else 0)