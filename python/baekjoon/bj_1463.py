# https://www.acmicpc.net/problem/1463
# 1로 만들기

import sys

i = int(sys.stdin.readline())

dp = [0, 0, 1, 1]

for n in range(4, i + 1):
    a = []
    if n % 3 == 0:
        a.append(dp[n // 3] + 1)

    if n % 2 == 0:
        a.append(dp[n // 2] + 1)

    a.append(dp[n - 1] + 1)

    dp.append(min(a))

print(dp[i])
