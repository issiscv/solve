# https://www.acmicpc.net/problem/11279
# 최대 힙

import sys
import heapq

n = int(sys.stdin.readline().strip())
queue = []

for _ in range(n):
    x = int(sys.stdin.readline().strip())
    if x == 0:
        if len(queue) == 0:
            print(0)
        else:
            print(heapq.heappop(queue)[1])
    else:
        heapq.heappush(queue, (-x, x)) #(우선순위, 값)


