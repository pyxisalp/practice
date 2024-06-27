import sys
input = sys.stdin.readline

n = int(input())
cnt = 0
curr = 666

while True:
    if '666' in str(curr):
        cnt += 1
    if n == cnt:
        print(curr)
        break
    curr += 1

# 생각보다 간단한 문제