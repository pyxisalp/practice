import sys
input = sys.stdin.readline

m = int(input())
state = list(map(int, input().split()))
n = int(input())

for _ in range(n):
    s, p = map(int, input().split())
    if s == 1:
        for i in range(p - 1, m, p):
            state[i] = 1 - state[i]
    else:
        p -= 1
        state[p] = 1 - state[p]
        for i in range(1, m // 2):
            if p + i < m and p - i >= 0 and state[p + i] == state[p - i]:
                state[p + i] = 1 - state[p + i]
                state[p - i] = 1 - state[p - i]
            else: 
                break

for i in range(len(state)):
    print(state[i], end=' ')
    if i % 20 == 19:
        print()
print()