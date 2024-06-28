import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = list(map(int, input().split()))
dp = [0] * 100001

left = 0
right = 1
dp[arr[left]] = 1
cnt = 1
result = 0
while right < n:
    if dp[arr[right]] < k:
        dp[arr[right]] += 1
        right += 1
        cnt += 1
    else:
        dp[arr[left]] -= 1
        left += 1
        cnt -= 1
    result = max(result, cnt)

print(result)