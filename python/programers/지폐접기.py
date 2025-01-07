# https://school.programmers.co.kr/learn/courses/30/lessons/340199

def solution(wallet, bill):
    answer = 0
    w_max, w_min = max(wallet), min(wallet)
    b_max, b_min = max(bill), min(bill)

    while b_min > w_min or b_max > w_max:
        tmp = b_max // 2
        b_max = max(tmp, b_min)
        b_min = min(tmp, b_min)
        answer += 1

    return answer
