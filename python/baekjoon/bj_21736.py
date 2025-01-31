# https://www.acmicpc.net/problem/21736
# 헌내기는 친구가 필요해
# TIP: BFS

import sys
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, - 1]

visited = set()


def bfs(x, y):
    global n, m
    queue = deque()
    queue.append((x, y))
    visited.add((x, y))
    count = 0
    while queue:
        cx, cy = queue.popleft()

        if map_data[cx][cy] == 'P':
            count += 1

        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if (nx, ny) not in visited and 0 <= nx < n and 0 <= ny < m and map_data[nx][ny] != 'X':
                queue.append((nx, ny))
                visited.add((nx, ny))

    return count if count != 0 else 'TT'


n, m = map(int, sys.stdin.readline().strip().split())

map_data = []
start_x, start_y = 0, 0

for i in range(n):
    tmp = []
    for j, value in enumerate(sys.stdin.readline().strip()):
        tmp.append(value)
        if value == 'I':
            start_x, start_y = i, j
    map_data.append(tmp)

count = bfs(start_x, start_y)

print(count)
