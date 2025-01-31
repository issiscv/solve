# https://www.acmicpc.net/problem/17626
# Four Squares
# TIP: 어떠한 자연수는 반드 시 넷 이하의 제곱수의 합으로 이뤄져 있음
# n이 제곱수이면 최소 개수는 1이다.
# n보다 작거나 같은 제곱수 i²을 뺐을 때 값이 제곱수이면 최소 개수는 2이다.
# n보다 작거나 같은 제곱수 i²을 뺀 값보다 작거나 같은 또 다른 제곱수 j²을 뺐을 때 남은 값이 제곱수이면 최소 개수는 3이다.
# 위 조건에 해당하지 않으면 최소 개수는 4이다.


import math

n = int(input())


def force(n):
    if int(math.sqrt(n)) == math.sqrt(n):
        return 1

    for i in range(1, int(math.sqrt(n)) + 1):
        if math.sqrt(n - i ** 2) == int(math.sqrt(n - i ** 2)):
            return 2

    for i in range(1, int(math.sqrt(n)) + 1):
        for j in range(1, int(math.sqrt(n - i ** 2)) + 1):
            if math.sqrt(n - i ** 2 - j ** 2) == int(math.sqrt(n - i ** 2 - j ** 2)):
                return 3

    return 4


print(force(n))
