import sys
input = sys.stdin.readline

arr = input().rstrip()
n = len(arr)
i = 0
curr = 1

while True:
    for j in str(curr):
        if arr[i] == j:
            i += 1
            if i == n: break
    if i == n:
        print(curr)
        break
    curr += 1
