import sys
input = sys.stdin.readline

s = input().rstrip()
t = input().rstrip()

tLen = len(t)
stk = []

for i in s:
    stk.append(i)
    
    if ''.join(stk[-tLen:]) == t:
        for _ in range(tLen):
            stk.pop()

print(''.join(stk) if stk else 'FRULA')