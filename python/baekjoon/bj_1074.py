# https://www.acmicpc.net/problem/1074
# Z
# TIP: 사분면을 이용해서 푼다.

import sys

n, r, c = map(int, (sys.stdin.readline().strip().split()))

result = 0

def dfs(size, r, c):
    if size == 1:
        return
    global result
    size = size // 2
    if r < size and c < size:
        dfs(size, r, c)
    elif r < size and c >= size:
        result += size * size
        dfs(size, r, c - size)
    elif r >= size and c < size:
        result += 2 * size * size
        dfs(size, r - size, c)
    elif r >= size and c >= size:
        result += 3 * size * size
        dfs(size, r - size, c - size)


dfs(2 ** n, r, c)
print(result)
