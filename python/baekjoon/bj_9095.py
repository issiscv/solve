# https://www.acmicpc.net/problem/9095
# 1, 2, 3 더하기

import sys

t = int(sys.stdin.readline())

for _ in range(t):
    dp = {1: 1, 2: 2, 3: 4}
    n = int(sys.stdin.readline())
    for x in range(4, n + 1):
        dp[x] = dp[x-1] + dp[x-2] + dp[x-3]
    print(dp[n])