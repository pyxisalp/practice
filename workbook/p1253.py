import sys
input = sys.stdin.readline

n = int(input())
a = sorted(list(map(int, input().split())))

answer = 0
for i in range(n):
    l = 0
    r = n - 1

    while l < r:
        temp = a[l] + a[r]

        if temp == a[i]:
            if i == l:
                l += 1
            elif i == r:
                r -= 1
            else:
                answer += 1
                break
        elif temp > a[i]:
            r -= 1
        else:
            l += 1

print(answer)