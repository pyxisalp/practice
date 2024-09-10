import sys
input = sys.stdin.readline

n = int(input())
pos = [int(input().split()[1]) for _ in range(n)]
pos.append(0)

result = 0
stk = [0]
for y in pos:
    temp = y

    while stk[-1] > y:
        if stk[-1] != temp:
            result += 1
            temp = stk[-1]
        stk.pop()
    stk.append(y)

print(result)
