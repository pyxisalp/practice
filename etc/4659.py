import sys
input = sys.stdin.readline

while (True):
    pw = input().rstrip()
    n = len(pw)
    if (pw == 'end'): break
    flag1 = 0
    flag2c = flag2v = flag3 = 1

    for i in range(n):
        if pw[i] in 'aeiou': flag1 = 1
        if (i < n - 2):
            if (pw[i] in 'aeiou' and pw[i + 1] in 'aeiou' and pw[i + 2] in 'aeiou'):
                flag2v = 0
            elif (pw[i] not in 'aeiou' and pw[i + 1] not in 'aeiou' and pw[i + 2] not in 'aeiou'):
                flag2c = 0
        if (i < n - 1):
            if (pw[i] == pw[i + 1] and pw[i] != 'e' and pw[i] != 'o'):
                flag3 = 0
    if (flag1 and flag2c and flag2v and flag3):
        print(f'<{pw}> is acceptable.')
    else:
        print(f'<{pw}> is not acceptable.')
