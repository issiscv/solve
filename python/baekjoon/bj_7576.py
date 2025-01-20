# https://www.acmicpc.net/problem/7576
# 토마토
# TIP: BFS, 토마토가 있는 좌표를 초기 시작 큐에 넣어서 실행

import sys
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

visited = set()


def bfs():
    queue = deque()

    for (x, y) in point_list:
        queue.append((x, y))
        visited.add((x, y))

    count = 0
    while queue:
        size = len(queue)
        for _ in range(size):
            cx, cy = queue.popleft()
            for i in range(4):
                nx = cx + dx[i]
                ny = cy + dy[i]
                if (nx, ny) not in visited and 0 <= nx < n and 0 <= ny < m and map_list[nx][ny] == 0:
                    queue.append((nx, ny))
                    visited.add((nx, ny))
                    map_list[nx][ny] = 1
        count += 1
    return count - 1


def valid():
    global n, m
    for x in range(n):
        for y in range(m):
            if map_list[x][y] == 0:
                return False
    return True


m, n = map(int, sys.stdin.readline().strip().split())

map_list = []

for _ in range(n):
    tmp_list = list(map(int, sys.stdin.readline().strip().split()))
    map_list.append(tmp_list)

point_list = []

for x in range(n):
    for y in range(m):
        if map_list[x][y] == 1:
            point_list.append((x, y))

count = bfs()
print(count if valid() else -1)
