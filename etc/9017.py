import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    cnt = [0] * (201)
    team = [[] for __ in range(201)]

    for i in range(n):
        cnt[arr[i]] += 1

    j = 1
    for i in range(n):
        if (cnt[arr[i]] != 6):
            continue
        team[arr[i]].append(j)
        j += 1

    win = 0
    min_score = 4000
    for i in range(1, 201):
        if (cnt[i] != 6):
            continue
        if (sum(team[i][:4]) < min_score):
            win = i
            min_score = sum(team[i][:4])
        elif (sum(team[i][:4]) == min_score and team[i][4] < team[win][4]):
            win = i

    print(win)

    # 사람보다 팀 번호가 클 수 있다.

