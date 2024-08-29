import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())
a = deque(list(map(int, input().split())))
check = deque([0] * n * 2)
cnt = 0
result = 0

while True:
    result += 1

    # step 1
    a.appendleft(a.pop())
    check.appendleft(check.pop())
    check[n - 1] = 0

    # step 2
    for i in range(n - 2, -1, -1):
        if check[i] == 1 and a[i + 1] > 0 and check[i + 1] == 0:
            a[i + 1] -= 1
            check[i + 1] = 1
            check[i] = 0
    check[n - 1] = 0

    # step 3
    if a[0] > 0:
        a[0] -= 1
        check[0] = 1

    # step 4
    if a.count(0) >= k:
        break

print(result)