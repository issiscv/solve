# https://www.acmicpc.net/problem/2630
# 색종이 만들기
# TIP: 4 분면을 사용 한다,

import sys

blue, white = 0, 0
def dfs(row, col, size):
    global blue, white
    if size == 0:
        return

    is_valid = valid(row, col, size)
    if is_valid:
        if map_list[row][col] == 0:
            white += 1
        else:
            blue += 1
        return

    size = size // 2

    dfs(row, col, size)
    dfs(row, col + size, size)
    dfs(row + size, col, size)
    dfs(row + size, col + size, size)

# 0 4
def valid(row, col, size):
    white = 0
    blue = 0
    for x in range(row, row + size):
        for y in range(col, col + size):

            if map_list[x][y] == 0:
                white += 1
            else:
                blue += 1
    if blue == size ** 2 or white == size ** 2:
        return True
    else:
        return False

n = int(sys.stdin.readline().strip())

map_list = []

for _ in range(n):
    map_list.append(list(map(int, sys.stdin.readline().strip().split())))

dfs(0, 0, n)

print(white, blue)
