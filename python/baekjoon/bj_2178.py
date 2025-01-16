# https://www.acmicpc.net/problem/2178
# 미로탐색

import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())

map_list = []

for _ in range(n):
    tmp = []
    str = sys.stdin.readline().strip()
    for s in str:
        tmp.append(int(s))
    map_list.append(tmp)

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def bfs(x, y):
    global n, m, dx, dy
    queue = deque()
    queue.append((x, y))
    visited = set()
    visited.add((x, y))

    count = 1
    while queue:
        size = len(queue)
        for _ in range(size):
            (cx, cy) = queue.popleft()
            if cx == n - 1 and cy == m - 1:
                return count
            for i in range(4):
                nx, ny = cx + dx[i], cy + dy[i]
                if (nx, ny) not in visited and 0 <= nx < n and 0 <= ny < m and map_list[nx][ny] == 1:
                    visited.add((nx, ny))
                    queue.append((nx, ny))

        count += 1

    return None

print(bfs(0, 0))