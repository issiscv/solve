# https://www.acmicpc.net/problem/18110
# solved.ac
import sys


def my_round(x):
    if x - int(x) >= 0.5:
        return int(x) + 1
    else:
        return int(x)


n = int(sys.stdin.readline().strip())

if n:
    data = []
    for i in range(n):
        data.append(int(sys.stdin.readline().strip()))

    l = my_round(n * 0.15)
    data.sort()
    if l > 0:
        print(my_round(sum(data[l:-l]) / len(data[l:-l])))
    else:
        print(my_round(sum(data) / len(data)))
else:
    print(0)
