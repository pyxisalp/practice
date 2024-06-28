import sys
input = sys.stdin.readline

n, x = map(int, input().split())
freq = list(map(int, input().split()))
temp = sum(freq[0:x])
arr = [temp]
acc_freq = temp

for i in range(x, n):
    temp += (freq[i] - freq[i - x])
    acc_freq = max(acc_freq, temp)
    arr.append(temp)

if acc_freq:
    print(acc_freq)
    print(arr.count(acc_freq))
else: print('SAD')

# sum을 for loop에서 사용하면 시간 초과