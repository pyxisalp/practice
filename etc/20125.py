import sys
input = sys.stdin.readline

n = int(input())
arr = [input().rstrip() for _ in range(n)]
result = [0] * 5

for i in range(n):
    for j in range(n):
        if (arr[i][j] == '*'):
            row = i + 1
            col = j
            break
    if (arr[i][j] == '*'): break

print(row + 1, col + 1)

i = row
j = col - 1
while (j >= 0 and arr[i][j] == '*'):
    result[0] += 1
    j -= 1

j = col + 1
while (j < n and arr[i][j] == '*'):
    result[1] += 1
    j += 1

i = row + 1
j = col
while (i < n and arr[i][j] == '*'):
    result[2] += 1
    i += 1

row = i
j = col - 1
while (i < n and arr[i][j] == '*'):
    result[3] += 1
    i += 1

i = row
j = col + 1
while (i < n and arr[i][j] == '*'):
    result[4] += 1
    i += 1

for i in result: print(i, end=' ')
print()