import sys
input = sys.stdin.readline

n = int(input())
words = [input().rstrip() for _ in range(n)]

a = [0] * 26
a_len = len(words[0])
result = 0
for i in words[0]: a[ord(i) - 65] += 1

for i in words[1:]:
    b = [0] * 26
    b_len = len(i)
    diff = 0
    diff_char = 0
    for j in i: b[ord(j) - 65] += 1
    for i in range(26): 
        if a[i] != b[i]:
            diff += abs(a[i] - b[i])
            diff_char += 1

    if abs(a_len - b_len) == 1 and diff == 1: result += 1
    elif a_len == b_len:
       if diff == 0: result += 1
       elif diff == 2 and diff_char == 2: result += 1

print(result)