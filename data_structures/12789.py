import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
q = deque(list(map(int, input().split())))
stk = deque([])
curr = 1

while q:
    if q[0] == curr:
        q.popleft()
        curr += 1
        continue
    else:
        if stk and stk[-1] == curr:
            stk.pop()
            curr += 1
            continue
        stk.append(q.popleft())
    
while stk:
    x = stk.pop()
    if x == curr:
        curr += 1

if n == curr - 1:
    print('Nice')
else:
    print('Sad')
