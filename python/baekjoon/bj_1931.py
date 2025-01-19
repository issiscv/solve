# https://www.acmicpc.net/problem/1931
# 회의실 배정
# TIP: 끝나는 시간으로 오름차순 1차적으로 정렬하되, 2차적으로 시작시간이 짧은 순으로 정렬해야함
# 시작 시간을 정렬해야 (1, 2)(2, 2) 와 같이 2가지 선택 가능

import sys

n = int(sys.stdin.readline().strip())

data = []
for _ in range(n):
    s, e = map(int, sys.stdin.readline().strip().split())
    data.append((s, e))

data.sort(key=lambda x: (x[1], x[0]))
count = 1

_, max_b = data[0]

for a, b in data[1:]:
    if a >= max_b:
        max_b = b
        count += 1

print(count)
