# https://www.acmicpc.net/problem/17219
# 비밀번호

import sys

n, m = list(map(int, sys.stdin.readline().strip().split()))

pwd_dic = {}
for _ in range(n):
    site, pwd = sys.stdin.readline().strip().split()
    pwd_dic[site] = pwd

for _ in range(m):
    target = sys.stdin.readline().strip()
    print(pwd_dic[target])
