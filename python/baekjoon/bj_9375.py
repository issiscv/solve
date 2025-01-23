# https://www.acmicpc.net/problem/9375
# 패션왕 신해빈
# TIP: 옷 종류 수 * (옷의 수 + 1(입지 않은걸 고려)) - 1(알몸인 상태를 제외)

import sys

t = int(sys.stdin.readline().strip())

for _ in range(t):
    n = int(sys.stdin.readline().strip())
    data_dict = {}
    for _ in range(n):
        _, a = sys.stdin.readline().strip().split()
        if a in data_dict:
            data_dict[a] += 1
        else:
            data_dict[a] = 1
    total = 1
    for count in data_dict.values():
        total *= (count + 1)

    print(total - 1)
