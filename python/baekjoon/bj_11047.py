# https://www.acmicpc.net/problem/11047
# 동전 0

import sys

n, k = map(int, sys.stdin.readline().split())

coins = []
for _ in range(n):
    coins.append(int(sys.stdin.readline()))

coins.sort(key=lambda x: -x)

c = 0
for x in coins:
    if k // x > 0:
        c += k // x
        k = k % x
    if k == 0:
        break

print(c)
