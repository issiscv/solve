# https://www.acmicpc.net/problem/2667
# 단지번호붙이기

import sys
from collections import deque

visited = set()
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def bfs(x, y):
    global n
    queue = deque()
    queue.append((x, y))
    visited.add((x, y))
    count = 1
    while queue:
        size = len(queue)
        for _ in range(size):
            cx, cy = queue.popleft()
            for i in range(4):
                nx = cx + dx[i]
                ny = cy + dy[i]
                if (nx, ny) not in visited and 0 <= nx < n and 0 <= ny < n and map_list[nx][ny] == 1:
                    queue.append((nx, ny))
                    visited.add((nx, ny))
                    count += 1
    return count

n = int(sys.stdin.readline().strip())

map_list = []

for _ in range(n):
    str = sys.stdin.readline().strip()
    tmp_list = []
    for value in str:
        tmp_list.append(int(value))
    map_list.append(tmp_list)

apt = {}

for i in range(n):
    for j in range(n):
        if map_list[i][j] == 1 and (i, j) not in visited:
            count = bfs(i, j)
            apt[(i, j)] = count

print(len(apt))

apt_list = sorted(list(apt.values()))

for x in apt_list:
    print(x)
