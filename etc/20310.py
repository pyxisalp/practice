import sys
input = sys.stdin.readline

s = input().rstrip()

zeros = s.count('0') // 2
ones = s.count('1') // 2

for _ in range(zeros):
    idx = s.rindex('0')
    s = s[:idx] + s[idx + 1:]

for _ in range(ones):
    idx = s.index('1')
    s = s[:idx] + s[idx + 1:]

print(s)