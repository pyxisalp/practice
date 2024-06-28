import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
pos = list(map(int, input().split()))

if m == 1:
    h = max(pos[0], n - pos[0])
else:
    h = pos[0]
    for i in range(m):
        if i == m - 1:
            temp = n - pos[-1]
        else:
            distance = pos[i + 1] - pos[i]
            if distance % 2:
                temp = distance // 2 + 1
            else:
                temp = distance // 2
        h = max(h, temp)

print(h)

# https://velog.io/@meganatc7/