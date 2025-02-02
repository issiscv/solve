# https://www.acmicpc.net/problem/30804
# 과일 탕후루
# 슬라이딩 윈도우 (Sliding Window): lt(왼쪽 포인터), rt(오른쪽 포인터)
# 딕셔너리 활용: 현재 윈도우 안에 있는 과일 종류와 개수를 관리하기 위해 dict(혹은 defaultdict) 사용.
# rt를 오른쪽으로 이동하며 새로운 과일 추가
# 과일 종류가 2개 초과하면: lt를 오른쪽으로 이동시키며 과일 개수를 줄임(개수가 0이 되면 딕셔너리에서 제거)
# 최대 길이 계산: 매번 rt - lt + 1로 윈도우의 길이를 계산하고, 최대값을 업데이트

import sys
from collections import defaultdict

n = int(sys.stdin.readline().strip())
data = list(map(int, sys.stdin.readline().strip().split()))

lt = 0
answer = 0
dd = defaultdict(int)

for rt in range(len(data)):
    dd[data[rt]] += 1

    while len(dd) > 2:
        dd[data[lt]] -= 1
        if dd[data[lt]] == 0:
            del dd[data[lt]]
        lt += 1
    answer = max(answer, rt - lt + 1)
print(answer)