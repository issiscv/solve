# https://www.acmicpc.net/problem/1764
# 듣보잡
# TIP: set, 교집합, 정렬 

import sys

n, m = map(int, sys.stdin.readline().strip().split())

n_set = set()
for _ in range(n):
    n_set.add(sys.stdin.readline().strip())

m_set = set()
for _ in range(n):
    m_set.add(sys.stdin.readline().strip())

answer = sorted(n_set & m_set)

print(len(answer))
print('\n'.join(answer))