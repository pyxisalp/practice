import sys
input = sys.stdin.readline

p, m = map(int, input().split())
q = []
for _ in range(p):
    l, n = input().rstrip().split()
    l = int(l)

    visited = 0
    for i in range(len(q)):
        lower, upper, num = q[i][:3]
        if l >= lower and l <= upper and num < m:
            visited = 1
            q[i][2] += 1
            q[i][3].append((l, n))
            break
    if not visited:
        q.append([l - 10, l + 10, 1, [(l, n)]])

for i in q:
    lower, upper, num, arr = i
    arr.sort(key=lambda x: x[1])
    if num == m:
        print("Started!")
        for j in arr:
            print(j[0], j[1])
    else:
        print("Waiting!")
        for j in arr:
            print(j[0], j[1])