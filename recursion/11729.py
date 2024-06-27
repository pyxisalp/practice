import sys
input = sys.stdin.readline

n = int(input())
arr = []

def func(num, start, end, temp):
    result = 0
    if num == 1:
        arr.append((start, end))
        return 1
    result += func(num - 1, start, temp, end)
    result += func(1, start, end, temp)
    result += func(num - 1, temp, end, start)
    return result

result = func(n, 1, 3, 2)
print(result)
for i in arr:
    print(i[0], i[1])