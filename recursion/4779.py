import sys
input = sys.stdin.readline

def func(l, length):
    if length == 1:
        return
    for i in range(l + length // 3, l + (length // 3) * 2):
        string[i] = ' '
    func(l, length // 3)
    func(l + (length // 3) * 2, length // 3)

while True:
    try:
        n = int(input())
        string = ['-'] * (3 ** n)
        func(0, 3 ** n)
        print(''.join(string))
    except:
        break
