import sys
input = sys.stdin.readline

n, m = map(int, input().split())
stk = []

def dfs():
    if len(stk) == m:
        print(' '.join(map(str, stk)))
        return
    
    for i in range(1, n + 1):
        if i in stk:
            continue

        stk.append(i)
        dfs()
        stk.pop()

dfs()
