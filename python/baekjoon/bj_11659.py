# https://www.acmicpc.net/problem/9375
# 구간 합 구하기-4
# TIP: 값을 누적하여 list 에 저장

import sys

n, m = map(int, sys.stdin.readline().strip().split())
numbers = list(map(int, sys.stdin.readline().strip().split()))

data = [0]
tmp = 0

# 5 9 12 14 15
for num in numbers:
    tmp += num
    data.append(tmp)

for _ in range(m):
    a, b = map(int, sys.stdin.readline().strip().split())
    print(data[b] - data[a - 1])
