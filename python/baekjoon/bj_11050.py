# https://www.acmicpc.net/problem/11050
# 이항 계수1

data = list(map(int, input().split(' ')))
dp = {}


def comb(n, k):
    if (n, k) in dp:
        return dp[(n, k)]
    if n == k or k == 0:
        return 1
    dp[(n, k)] = comb(n - 1, k - 1) + comb(n - 1, k)
    return dp[(n, k)]


print(comb(data[0], data[1]))
