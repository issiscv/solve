# https://www.acmicpc.net/problem/11724
# 연결 요소의 개수

import sys
sys.setrecursionlimit(10**7)


def dfs(current_node):
    visited[current_node] = True
    for next_node in graph[current_node]:
        if not visited[next_node]:
            dfs(next_node)


n, m = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False for _ in range(n + 1)]
answer = 0

for node in range(1, n + 1):
    if not visited[node]:
        dfs(node)
        answer += 1

print(answer)
