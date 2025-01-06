# https://www.acmicpc.net/problem/11866
# 요세푸스 문제
from collections import deque

# 1 2 3 4 5 6 7
data = list(map(int, input().split()))
n = data[0]
k = data[1]

queue = deque(range(1, n + 1))
answer = []
while queue:
    for i in range(k - 1):
        queue.append(queue.popleft())
    answer.append(queue.popleft())

print(f"<{', '.join(map(str, answer))}>")
