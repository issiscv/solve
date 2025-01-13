# https://www.acmicpc.net/problem/1260
# DFS와 BFS

import sys
from collections import deque

data = list(map(int, sys.stdin.readline().split()))
n = data[0]
m = data[1]
v = data[2]

graph = [[] for _ in range(n + 1)]

def dfs(node):
    d_visited[node] = True
    print(node, end=' ')
    for next_node in graph[node]:
        if not d_visited[next_node]:
            dfs(next_node)


def bfs(node):
    queue = deque()
    queue.append(node)
    b_visited[node] = True
    while queue:
        tmp = queue.popleft()
        print(tmp, end=' ')
        for x in graph[tmp]:
            if not b_visited[x]:
                queue.append(x)
                b_visited[x] = True


for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

for x in graph:
    x.sort()

d_visited = [False for _ in range(n + 1)]
b_visited = [False for _ in range(n + 1)]

dfs(v)
print()
bfs(v)
