# https://www.acmicpc.net/problem/2606
# 바이러스
# 그래프, DFS

import sys

count = 0

def dfs(node):
    global count

    next_nodes = nodes[node]
    visited[node] = True
    count += 1
    for next_node in next_nodes:
        if not visited[next_node]:
            dfs(next_node)


n = int(sys.stdin.readline().strip())
e = int(sys.stdin.readline().strip())

visited = []
nodes = []
for _ in range(n + 1):
    nodes.append([])
    visited.append(False)

for _ in range(e):
    a, b = map(int, sys.stdin.readline().strip().split())
    nodes[a].append(b)
    nodes[b].append(a)


dfs(1)
print(count - 1)
