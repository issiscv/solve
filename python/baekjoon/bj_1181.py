# https://www.acmicpc.net/problem/1181
# 단어 정렬

n = int(input())

data = []
for i in range(n):
    data.append(input())

data = list(set(data))

data.sort(key=lambda x: (len(x), x))
for i in data:
    print(i)
