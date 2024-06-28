import sys
input = sys.stdin.readline

n = int(input())

arr = [0] * (n + 1)

for i in range(2, n + 1):
    if (i > 3):
        if (arr[i - 3]): arr[i] = 0
        else: arr[i] = 1
    elif (i > 1):
        if (arr[i - 1]): arr[i] = 0
        else: arr[i] = 1

if (arr[n]): print('CY')
else: print('SK')

# dp를 사용하라는 의도는 알겠지만, 결과가 홀짝에 따라 정해져서 굳이라는 생각이 든다.