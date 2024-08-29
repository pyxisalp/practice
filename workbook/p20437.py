import sys
input = sys.stdin.readline

for _ in range(int(input())):
    w = input().rstrip()
    k = int(input())
    n = len(w)
    arr = [[] for __ in range(26)]

    minLen = n + 1
    maxLen = 0

    for i in range(n):
        arr[ord(w[i]) - ord('a')].append(i)

    for i in range(26):
        m = len(arr[i])
        if m == 0:
            continue
        minTmp = n + 1
        maxTmp = 0
        for j in range(m - k + 1):
            minTmp = min(minTmp, arr[i][j + k - 1] - arr[i][j] + 1)
            maxTmp = max(maxTmp, arr[i][j + k - 1] - arr[i][j] + 1)
        if minTmp < minLen:
            minLen = minTmp
        if maxTmp > maxLen:
            maxLen = maxTmp

    if minLen == n + 1 or maxLen == 0:
        print(-1)
    else:
        print(minLen, maxLen)
    