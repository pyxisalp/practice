import sys
input = sys.stdin.readline

n, m = map(int, input().split())
keywords = {}
result = n
for _ in range(n):
    keyword = input().rstrip()
    keywords[keyword] = 1
for _ in range(m):
    inputs = list(input().rstrip().split(','))
    for i in inputs:
        if i in keywords:
            if keywords[i] == 1:
                keywords[i] = 0
                result -= 1
    print(result)