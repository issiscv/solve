# https://www.acmicpc.net/problem/2579
# 계단오르기
import sys

# 6
# 10
# 20
# 15
# 25
# 10
# 20

n = int(sys.stdin.readline())

data = []
for _ in range(n):
    data.append(int(sys.stdin.readline()))

dp = []
for i in range(n):
    if i == 0:
        dp.append(data[0])
    if i == 1:
        dp.append(data[0] + data[1])
    if i == 2:
        dp.append(max(dp[0] + data[2], data[1] + data[2]))
    if i >= 3:
        dp.append(max(dp[i - 3] + data[i - 1] + data[i], dp[i - 2] + data[i])) # 점화식 사용 dp[3] 까지는 계산하여 확인 필요

print(dp[-1])
