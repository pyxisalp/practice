import sys
input = sys.stdin.readline

word = str(input().strip()).upper()
arr = [0] * 26
maxCnt = 0
maxChar = []

for i in word: 
    arr[ord(i) - 65] += 1

for i in range(26):
    if (arr[i] > maxCnt):
        maxCnt = arr[i]
        maxChar = [chr(i + 65)]
    elif (arr[i] == maxCnt):
        maxChar.append(chr(i + 65))

if (len(maxChar) == 1): print(maxChar[0])
else: print('?')

# 문자열.count(문자)를 사용하면 편할 듯
# count를 사용하는 것이 빠른데 왜 그런지 모르겠음