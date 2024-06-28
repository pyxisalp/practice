import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = []

for _ in range(n):
    el = list(map(int, input().split()))
    arr.append(el)

arr.sort(key = lambda x: (-x[1], -x[2], -x[3]))

rank = 1
for i in range(n):
    if (arr[i][0] == k):
        if (i == 0):
            print(rank)
        elif (arr[i][1] == arr[i - 1][1] and
            arr[i][2] == arr[i - 1][2] and
            arr[i][3] == arr[i - 1][3]):
            print(rank)
        else:
            rank = i + 1
            print(rank)
        break
    elif (arr[i][1] == arr[i - 1][1] and
          arr[i][2] == arr[i - 1][2] and
          arr[i][3] == arr[i - 1][3]):
        pass
    else:
        rank = i + 1

"""
arr.sort(key = lambda x: (x[1], x[2], x[3]), reverse=True)도 가능
복잡하게 작성했지만, k와 메달 수가 같으면 종료해도 문제 없을 것 같다.
"""