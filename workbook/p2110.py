import sys
input = sys.stdin.readline

n, c = map(int, input().split())
pos = [int(input()) for _ in range(n)]
pos.sort()

l = 1
r = pos[-1] - pos[0] + 1
answer = 0

while l < r:
    m = (l + r) // 2
    prev = 0
    num = 1

    for i in range(1, n):
        if pos[i] - pos[prev] >= m:
            prev = i
            num += 1

    if num < c:
        r = m
    else:
        l = m + 1
        answer = m

print(answer)