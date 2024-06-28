import sys
input = sys.stdin.readline

n, game = input().split()
n = int(n)
s = set()

for _ in range(n): s.add(input().rstrip())
k = len(s)
if (game == 'Y'): print(k)
elif (game == 'F'): print(k // 2)
else: print(k // 3)