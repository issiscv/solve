# https://www.acmicpc.net/problem/1921
# 최소 힙
# TIP: heapq 모듈 사용

import heapq
import sys

n = int(sys.stdin.readline().strip())

queue = []

for _ in range(n):
    x = int(sys.stdin.readline().strip())
    if x == 0:
        print(0) if len(queue) == 0 else print(heapq.heappop(queue))
    else:
        heapq.heappush(queue, x)
