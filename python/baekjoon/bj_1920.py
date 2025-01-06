# https://www.acmicpc.net/problem/1920
# 수 찾기

n = input()
a_list = input().split()
a_set = set(a_list)

m = input()
m_list = input().split()

for i in m_list:
    if i in a_set:
        print(1)
    else:
        print(0)


