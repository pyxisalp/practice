import sys
input = sys.stdin.readline

n = int(input())
n5 = n // 5
n3 = -1

while n5 > 0:
    if (n - n5 * 5) % 3 == 0:
        n3 = (n - n5 * 5) // 3
        break
    n5 -= 1

if n3 == -1:
    if n % 3 == 0:
        print(n // 3)
    else:
        print(-1)
else:
    print(n5 + n3)