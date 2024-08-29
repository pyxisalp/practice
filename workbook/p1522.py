import sys
input = sys.stdin.readline

s = list(input().rstrip())

n = len(s)
cnt_a = s.count('a')
result = 1000

for i in range(n):
    cnt_b = 0
    j = 0

    while j < cnt_a:
        if s[(i + j) % n] == 'b':
            cnt_b += 1
        j += 1
    result = min(result, cnt_b)

print(result)