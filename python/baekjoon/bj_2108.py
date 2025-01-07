# https://www.acmicpc.net/problem/2108
# 통계학
import sys

def my_round(num):# 소수점 첫째자리에서 반올림
    if num >= 0:
        return int(num + 0.5)
    else:
        return int(num - 0.5)

n = int(sys.stdin.readline())
data = []
mode = {}
for _ in range(n):
    num = int((sys.stdin.readline()))
    data.append(num)
    mode.setdefault(num, 0) # dict 기본 값 설정
    mode[num] += 1

max_count = max(mode.items(), key=lambda x: x[1])[1] # dict.itesm() -> (key, value) tuple 형으로 나옴
max_mode = [num for num, count in mode.items() if count >= max_count]
data.sort()
max_mode.sort()

print(my_round(sum(data) / len(data)))
print((data[len(data) // 2] + data[len(data) // 2 - 1]) / 2 if len(data) % 2 == 0 else data[len(data) // 2])
print(max_mode[0] if len(max_mode) == 1 else max_mode[1])
print(abs(max(data) - min(data)))
