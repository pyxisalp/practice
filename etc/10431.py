import sys
input = sys.stdin.readline

for _ in range(int(input())):
    arr = list(map(int, input().split()))
    cnt = 0

    for i in range(1, 21):
        for j in range(1, 21 - i):
            if (arr[j] > arr[j + 1]):
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                cnt += 1

    print(arr[0], cnt)

    # bubble sortÀÇ time complexity