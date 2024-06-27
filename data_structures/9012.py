import sys
from collections import deque
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    stk = deque(input().rstrip())
    left = right = 0

    flag = True
    while stk:
        if stk.pop() == ')':
            right += 1
        else:
            left += 1
        if left > right:
            flag = False
            break
    if left != right:
        flag = False

    if flag:
        print('YES')
    else:
        print('NO')
