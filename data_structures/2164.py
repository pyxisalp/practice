from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
arr = deque(range(1, n + 1))
num = len(arr)

while num != 1:
    arr.popleft()
    arr.append(arr.popleft())
    num -= 1

print(arr[0])
