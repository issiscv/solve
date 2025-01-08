# https://www.acmicpc.net/problem/11399
# ATM

import sys

_ = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().split()))
data.sort()

sum = 0
total = 0
for d in data:
    sum += d
    total += sum

print(total)
