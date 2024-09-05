import sys
input = sys.stdin.readline

while True:
    s = input().rstrip()
    
    if s == 'end':
        break

    xLen = s.count('X')
    oLen = s.count('O')
    pLen = s.count('.')

    xFlag = False
    oFlag = False
    flag = True

    # 가로
    for i in range(3):
        temp = set(s[i * 3:i * 3 + 3])

        if len(temp) == 1:
            if 'X' in temp:
                xFlag = True
            elif 'O' in temp:
                oFlag = True
        
    # 세로
    for i in range(3):
        temp = set(s[i::3])

        if len(temp) == 1:
            if 'X' in temp:
                xFlag = True
            elif 'O' in temp:
                oFlag = True

    # 대각선
    temp = set(s[0] + s[4] + s[8])

    if len(temp) == 1:
            if 'X' in temp:
                xFlag = True
            elif 'O' in temp:
                oFlag = True

    temp = set(s[2] + s[4] + s[6])

    if len(temp) == 1:
            if 'X' in temp:
                xFlag = True
            elif 'O' in temp:
                oFlag = True

    if xFlag:
        if xLen != oLen + 1:
            flag = False
    
    if oFlag:
        if xLen != oLen:
            flag = False

    if xFlag and oFlag:
        flag = False
    
    if not xFlag and not oFlag:
        if pLen > 0:
            flag = False
        if xLen != oLen + 1:
            flag = False

    print('valid' if flag else 'invalid')