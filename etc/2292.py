import sys
input = sys.stdin.readline

n = int(input())

if (n == 1): print(1)
else:
    result = cnt = row = 1
    col = 2
    while (cnt < n):
        cnt += (row + col) * 2
        row += 2
        col += 1
        result += 1
    print(result)