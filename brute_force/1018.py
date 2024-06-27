import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [input().rstrip() for _ in range(n)]
result = 64

for i in range(n - 7):
    for j in range(m - 7):
        black = 0
        white = 0
        for p in range(i, i + 8):
            for q in range(j, j + 8):
                if (p + q) % 2 == 0:
                    if arr[p][q] != 'B':
                        black += 1
                    else:
                        white += 1
                else:
                    if arr[p][q] != 'W':
                        black += 1
                    else:
                        white += 1
        result = min(result, black, white)
print(result)
