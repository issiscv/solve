# https://www.acmicpc.net/problem/2164
# 카드2
from collections import deque

n = int(input())
queue = deque(range(1, n + 1))

while (len(queue)) > 1:
    queue.popleft()
    queue.append(queue.popleft())

print(queue[0])
