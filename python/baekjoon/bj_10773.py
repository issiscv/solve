# https://www.acmicpc.net/problem/10773
# 제로

k = int(input())
stack = []

for i in range(k):
    num = int(input())
    if stack and num == 0:
        stack.pop()
    else:
        stack.append(num)

print(sum(stack))
