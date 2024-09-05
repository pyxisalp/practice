import sys
input = sys.stdin.readline

n, k, p, x = map(int, input().split())
x = str(x).zfill(k)

result = -1
seg = {'0': [1, 1, 1, 1, 1, 1, 0],
       '1': [0, 1, 1, 0, 0, 0, 0],
       '2': [1, 1, 0, 1, 1, 0, 1],
       '3': [1, 1, 1, 1, 0, 0, 1],
       '4': [0, 1, 1, 0, 0, 1, 1],
       '5': [1, 0, 1, 1, 0, 1, 1],
       '6': [1, 0, 1, 1, 1, 1, 1],
       '7': [1, 1, 1, 0, 0, 0, 0],
       '8': [1, 1, 1, 1, 1, 1, 1],
       '9': [1, 1, 1, 1, 0, 1, 1]}

for i in range(1, n + 1):
    num = str(i).zfill(k)
    temp = 0

    for j in range(k):
        for l in range(7):
            if seg[x[j]][l] != seg[num[j]][l]:
                temp += 1

    if temp <= p:
        result += 1

print(result)
