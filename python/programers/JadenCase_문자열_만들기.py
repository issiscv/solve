# https://school.programmers.co.kr/learn/courses/30/lessons/12951

def solution(s):
    answer = []
    data = s.split(' ')

    for d in data:
        answer.append(d.capitalize())
        # capitalize 문자열 전체에서 맨 첫 글자만 대문자로 만들고, 나머지는 모두 소문자로 변환합니다.
        # title 는 문자열을 단어 단위로 나눠 각 단어의 첫 글자만 대문자로, 나머지는 소문자로 변환합니다.
    return ' '.join(answer)


print(solution("3people unFollowed me"))
print(solution("for the last week"))
