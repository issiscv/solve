# https://www.acmicpc.net/problem/11866
# 집합
# TIP: 집합, set 의 discard 활용

import sys

n = int(sys.stdin.readline().strip())

s = set()
for _ in range(n):
    data = sys.stdin.readline().strip().split()

    operator = data[0]
    num = int(data[1]) if len(data) > 1 else None

    if operator == 'add':
        s.add(num)
    elif operator == 'remove':
        s.discard(num)
    elif operator == 'check':
        print(1 if num in s else 0)
    elif operator == 'toggle':
        if num in s:
            s.remove(num)
        else:
            s.add(num)
    elif operator == 'all':
        s = set(x for x in range(1, 21))
    elif operator == 'empty':
        s.clear()
