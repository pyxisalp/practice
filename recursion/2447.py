import sys
input = sys.stdin.readline

n = int(input())
pat = [['*'] * n for _ in range(n)]

def func(i, j, num):
    if num == 1:
        return
    
    length = num // 3
    for p in range(i + length, i + length * 2):
        for q in range(j + length, j + length * 2):
            pat[p][q] = ' '
    func(i, j, length)
    func(i, j + length, length)
    func(i, j + length * 2, length)
    func(i + length, j, length)
    func(i + length, j + length * 2, length)
    func(i + length * 2, j, length)
    func(i + length * 2, j + length, length)
    func(i + length * 2, j + length * 2, length)

func(0, 0, n)

for i in pat:
    for j in i:
        print(j, end='')
    print()