# https://www.acmicpc.net/problem/18870
# 좌표 압축
# TIP: list 의 index 는 O(n) 이 걸리기 때문에 dict 자료구조 사용
# 서로 다른 좌표 -> set 사용

import sys

n = int(sys.stdin.readline().strip())

data = list(map(int, sys.stdin.readline().strip().split()))
tmp_dict = {y: x for x, y in enumerate(sorted(set(data)))}

answer = []
for x in data:
    answer.append(tmp_dict[x])

print(*answer)
