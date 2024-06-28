import sys
input = sys.stdin.readline

n, k = map(int, input().split())
table = input().rstrip()
tag = [0] * n

for i in range(n):
    if table[i] == 'P': tag[i] = 2
    else: tag[i] = 1

for i in range(n):
    if table[i] == 'H': continue
    for j in range(i - k, i + k + 1):
        if j < 0 or j >= n or i == j: continue
        if tag[j] == 1:
            tag[j] = 0
            break

print(tag.count(0))
