import sys
input = sys.stdin.readline

def dfs(i, exp):
    if i > n:
        temp = exp.replace(' ', '')

        if eval(temp) == 0:
            print(exp)

        return
    
    dfs(i + 1, exp + ' ' + str(i))
    dfs(i + 1, exp + '+' + str(i))
    dfs(i + 1, exp + '-' + str(i))

for _ in range(int(input())):
    n = int(input())

    dfs(2, '1')
    print()
