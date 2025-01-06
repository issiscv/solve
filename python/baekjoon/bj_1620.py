# https://www.acmicpc.net/problem/1620
# 나는야 포켓몬 마스터 이다솜
import sys

data = list(map(int, sys.stdin.readline().strip().split()))

n = data[0]
k = data[1]

str_list = []
str_dict = {}
for i in range(n):
    str = sys.stdin.readline().strip()
    str_dict[str] = i + 1
    str_list.append(str)

for i in range(k):
    target = sys.stdin.readline().strip()
    if target.isdigit():
        print(str_list[int(target) - 1])
    else:
        print(str_dict[target])
