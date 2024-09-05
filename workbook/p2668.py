import sys
# from itertools import combinations
input = sys.stdin.readline

n = int(input())
num = list(range(1, n + 1))
arr = [0] + [int(input()) for _ in range(n)]

result = set()

def dfs(up, down, i):
    up.add(i)
    down.add(arr[i])

    if arr[i] in up:
        if up == down:
            result.update(up)
            return True
        return False
    
    return dfs(up, down, arr[i])

for i in range(1, n + 1):
    if i not in result:
        dfs(set(), set(), i)

print(len(result))

for i in sorted(list(result)):
    print(i)

# 조합: 메모리 초과
# result = 0
# flag = False

# for i in range(n, 0, -1):
#     idx = list(combinations(num, i))

#     for j in idx:
#         temp = []
        
#         for k in j:
#             temp.append(arr[k - 1])

#         if set(temp) == set(j):
#             result = i
#             flag = True
#             break

#     if flag:
#         break

# print(result)

# if flag:
#     for i in j:
#         print(i)