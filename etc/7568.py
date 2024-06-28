import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

for x1, y1 in arr:
	r = 1
	for x2, y2 in arr:
		if x1 < x2 and y1 < y2:
			r += 1
	print(r, end=' ')
print()

# brute force로 풀 수 있다는 것을 기억하자.