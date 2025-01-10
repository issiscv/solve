# https://www.acmicpc.net/problem/9461
# 파도반 수열

import sys

t = int(sys.stdin.readline())

for _ in range(t):
    dp = {1: 1, 2: 1, 3: 1, 4: 2, 5: 2}
    n = int(sys.stdin.readline())

    for i in range(6, n + 1):
        dp[i] = dp[i - 1] + dp[i - 5]
    print(dp[n])
