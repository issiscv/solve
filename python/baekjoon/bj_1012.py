# https://www.acmicpc.net/problem/1012
# 유기농 배추
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visited.add((x, y))
    global n, m
    while queue:
        cx, cy = queue.popleft()

        for i in range(4):
            nx = dx[i] + cx
            ny = dy[i] + cy
            if (nx, ny) not in visited and 0 <= nx < n and 0 <= ny < m and map_list[nx][ny] == 1:
                queue.append((nx, ny))
                visited.add((nx, ny))


t = int(input())

for _ in range(t):
    m, n, k = map(int, input().strip().split())
    map_list = []
    visited = set()

    for _ in range(n):
        map_list.append([0] * m)

    for _ in range(k):
        i, j = map(int, input().strip().split())
        map_list[j][i] = 1

    count = 0
    for i in range(n):
        for j in range(m):
            if (i, j) not in visited and map_list[i][j] == 1:
                bfs(i, j)
                count += 1

    print(count)

