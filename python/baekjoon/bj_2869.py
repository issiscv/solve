# https://www.acmicpc.net/problem/2869
# 달팽이는 올라가고 싶다
import math

data = input().split(' ')
a = int(data[0])
b = int(data[1])
v = int(data[2])

print(math.ceil((v - b) / (a - b)))
