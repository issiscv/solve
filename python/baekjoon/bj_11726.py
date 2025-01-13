# https://www.acmicpc.net/problem/11726
# 2xn 타일링
import sys

n = int(sys.stdin.readline())

dp = {1: 1, 2: 2}

for i in range(3, n + 1):
    dp[i] = (dp[i - 1] + dp[i - 2]) % 10007

print(dp[n] % 10007)
