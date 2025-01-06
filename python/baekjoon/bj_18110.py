# https://www.acmicpc.net/problem/18110
# solved.ac

def my_round(x):
    if x - int(x) >= 0.5:
        return int(x) + 1
    else:
        return int(x)


n = int(input())

data = []
for i in range(n):
    k = int(input())
    data.append(k)

l = my_round(n * 0.15)
data.sort()

if n:
    if l > 0:
        print(my_round(sum(data[l:-l]) / len(data[l:-l])))
    else:
        print(my_round(sum(data)/len(data)))
