# https://www.acmicpc.net/problem/9019
# DSLR
# TIP: BFS, 연산자를 문자열에 더하여 enqueu

import sys
from collections import deque


def bfs(start, target):
    queue = deque()
    queue.append((start, ''))
    visited = [''] * 10000

    while queue:
        tmp, ops = queue.popleft()

        if tmp == target:
            return ops

        d = (tmp * 2) % 10000
        s = 9999 if tmp == 0 else tmp - 1
        l = tmp % 1000 * 10 + tmp // 1000
        r = tmp % 10 * 1000 + tmp // 10

        if not visited[d]:
            visited[d] = True
            queue.append((d, ops + 'D'))

        if not visited[s]:
            visited[s] = True
            queue.append((s, ops + 'S'))

        if not visited[l]:
            visited[l] = True
            queue.append((l, ops + 'L'))

        if not visited[r]:
            visited[r] = True
            queue.append((r, ops + 'R'))


t = int(sys.stdin.readline())

for _ in range(t):
    a, b = map(int, sys.stdin.readline().strip().split())
    print(bfs(a, b))
