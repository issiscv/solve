# https://www.acmicpc.net/problem/2805
# 나무 자르기

import sys

n, m = map(int, sys.stdin.readline().split())

data = list(map(int, sys.stdin.readline().split()))

lt, rt = 1, max(data)

while lt <= rt:
    mid = (lt + rt) // 2
    sum = 0
    for num in data:
        if num >= mid:
            sum += num - mid
        if sum > m:
            break
    if sum >= m:
        lt = mid + 1
    else:
        rt = mid - 1

print(rt)
