import sys
input = sys.stdin.readline
from collections import deque

left = deque(input().rstrip())
right = deque()
m = int(input())
for _ in range(m):
    command = input().rstrip().split()
    if command[0] == 'L': 
        if left: right.appendleft(left.pop())
    elif command[0] == 'D': 
        if right: left.append(right.popleft())
    elif command[0] == 'B': 
        if left: left.pop()
    else: left.append(command[1])
print(''.join(left + right))
