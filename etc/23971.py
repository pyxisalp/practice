import sys
input = sys.stdin.readline

h, w, n, m = map(int, input().split())

print((1 + (w - 1) // (m + 1)) * (1 + (h - 1) // (n + 1)))

# print에 있는 수식을 이해하는 것이 중요할 듯