import sys
import itertools
input = sys.stdin.readline

s = input().rstrip()
t = input().rstrip()

result = 0

def dfs(x):
    global result 

    if x == s:
        result = 1
        return

    if len(x) == 0:
        return
    
    if x[-1] == 'A':
        dfs(x[:-1])

    if x[0] == 'B':
        dfs(x[1:][::-1])

dfs(t)
print(result)