import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n, k, t, m = map(int, input().split())
    score = [[0 for _ in range(k + 1)] for _ in range(n + 1)]
    submitNum = [0] * (n + 1)
    lastSubmit = [0] * (n + 1)
    for p in range(1, m + 1):
        i, j, s = map(int, input().split())
        score[i][j] = max(score[i][j], s)
        submitNum[i] += 1
        lastSubmit[i] = p
    rank = []
    for i in range(1, n + 1): 
        rank.append([i, sum(score[i]), submitNum[i], lastSubmit[i]])
    rank.sort(key=lambda x:(-x[1], x[2], x[3]))
    for i in range(n):
        if rank[i][0] == t:
            print(i + 1)
    