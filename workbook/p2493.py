import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
arr = [0] + list(map(int, input().split()))
stack = deque([1])
result = [0] * (n + 1)

for i in range(2, n + 1):
    while stack:
        if arr[stack[-1]] > arr[i]:
            result[i] = stack[-1]
            stack.append(i)
            break
        else:
            stack.pop()
    stack.append(i)

print(' '.join(map(str, result[1:])))