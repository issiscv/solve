# https://www.acmicpc.net/problem/1541
# 잃어버린 괄호

import sys

data = sys.stdin.readline().strip().split('-')

total = sum(map(int, data[0].split('+')))
for s in data[1:]:
    total -= sum(map(int, s.split('+')))

print(total)
