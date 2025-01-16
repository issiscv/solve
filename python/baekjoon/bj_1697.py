# https://www.acmicpc.net/problem/1697
# 숨바꼭질
import sys
from collections import deque

n, k = map(int, sys.stdin.readline().strip().split())

visited = {}

def bfs(start, end):
    queue = deque()
    queue.append(start)

    count = 0
    while queue:
        size = len(queue)
        for _ in range(size):
            pop = queue.popleft()
            visited[pop] = True
            if pop == end:
                return count

            if pop + 1 not in visited and 0 <= pop + 1 <= 100000:
                queue.append(pop + 1)
            if pop - 1 not in visited and 0 <= pop - 1 <= 100000:
                queue.append(pop - 1)
            if pop * 2 not in visited and 0 <= pop * 2 <= 100000:
                queue.append(pop * 2)

        count += 1
    return None

dis = bfs(n, k)
print(dis)