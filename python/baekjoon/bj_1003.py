# https://www.acmicpc.net/problem/1003
# 피보나치 함수

import sys

t = int(sys.stdin.readline())

dp = {0: 0, 1: 1}


def fibo(n):
    if n in dp:
        return dp[n]
    dp[n] = fibo(n - 1) + fibo(n - 2)
    return dp[n]


for _ in range(t):
    num = int(sys.stdin.readline())
    fibo(num)
    if num == 0:
        print(1, 0)
    elif num == 1:
        print(0, 1)
    else:
        print(dp[num-1], dp[num])
