# https://www.acmicpc.net/problem/11727
# 2xn 타일링 2

import sys

n = int(sys.stdin.readline())

dp = {1: 1, 2: 3, 3: 5}

for i in range(4, n + 1):
    dp[i] = (dp[i - 1] + (dp[i - 2] * 2) % 10007) % 10007

print(dp[n] % 10007)
