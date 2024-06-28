import sys
input = sys.stdin.readline

m = int(input())
arr = [0] * 21

for _ in range(m):
    cmd = input().split()

    if (cmd[0] == 'add'): arr[int(cmd[1])] = 1
    elif (cmd[0] == 'remove'): arr[int(cmd[1])] = 0
    elif (cmd[0] == 'check'):
        if (arr[int(cmd[1])]): print(1)
        else: print(0)
    elif (cmd[0] == 'toggle'):
        if (arr[int(cmd[1])]): arr[int(cmd[1])] = 0
        else: arr[int(cmd[1])] = 1
    elif (cmd[0] == 'all'):
        for i in range(21): arr[i] = 1
    else:
        for i in range(21): arr[i] = 0