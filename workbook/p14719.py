import sys
input = sys.stdin.readline

h, w = map(int, input().split())
arr = list(map(int, input().split()))
result = 0

m = min(arr)
arr = [arr[i] - m for i in range(w)]

for i in range(h - m):
    prev = -1
    for j in range(w):
        if arr[j]:
            if prev != -1:
                result += j - prev - 1
            prev = j
            arr[j] -= 1

print(result)

# 다른 풀이: https://seongonion.tistory.com/115