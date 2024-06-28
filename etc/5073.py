import sys
input = sys.stdin.readline

while True:
    a, b, c = map(int, input().split())

    if (a == 0): break

    arr = [a, b, c]
    arr.sort()
    if (arr[2] < arr[0] + arr[1]):
        if (a == b == c): print('Equilateral')
        elif (a == b or b == c or c == a): print('Isosceles')
        else: print('Scalene')
    else: print('Invalid')