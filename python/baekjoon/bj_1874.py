# https://www.acmicpc.net/problem/1874
# 스택 수열
import sys

n = int(sys.stdin.readline())

data = []
for _ in range(n):
    data.append(int(sys.stdin.readline()))

stack = []
op = []

current = 1
for val in data:
    while current <= val:
        stack.append(current)
        current += 1
        op.append("+")

    if stack[-1] == val:
        stack.pop()
        op.append("-")
    else:
        print("NO")
        break
else:
    print("\n".join(op))

# 1. current 를 현재 stack 에서 꺼내고자 하는 val 이 될때 까지 stack 에 넣고 값을 1 씩 증가하며 반복한다.
# 2. stack peek 값과 val 을 비교하여 같으면 pop
# 3. 같지 않다면 "NO" 출력
# 4. stack 수열이 가능하다면 op 내역 출력
