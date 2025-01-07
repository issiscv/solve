# https://www.acmicpc.net/problem/1966
# 프린터 큐
import sys
from collections import deque

t = int(sys.stdin.readline().strip())

for _ in range(t):
    _, m = list(map(int, sys.stdin.readline().strip().split()))
    data = list(map(int, sys.stdin.readline().strip().split()))
    queue = deque((idx, val) for idx, val in enumerate(data))

    count = 0
    while queue:
        max_val = max(queue, key=lambda x: x[1])[1]

        idx, weight = queue.popleft()
        if max_val == weight:
            count += 1
            if idx == m:
                break
        else:
            queue.append((idx, weight))

    print(count)