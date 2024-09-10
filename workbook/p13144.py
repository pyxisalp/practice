import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

l = r = 0
answer = 0
visited = [False] * 100001

while l <= r < n:
    if not visited[arr[r]]:
        visited[arr[r]] = True
        r += 1
        answer += (r - l)
    else:
        while visited[arr[r]]:
            visited[arr[l]] = False
            l += 1

print(answer)
