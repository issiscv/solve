# https://www.acmicpc.net/problem/4949
# 군형 잡힌 세상
while True:
    text = input()
    if text == '.':
        break
    result = ''.join(char for char in text if char in '()[]')
    stack = []
    for char in result:
        if char in '([':
            stack.append(char)
        elif char == ')':
            if len(stack) > 0 and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(char)
                break
        elif char == ']':
            if len(stack) > 0 and stack[-1] == '[':
                stack.pop()
            else:
                stack.append(char)
                break
    print('yes' if len(stack) == 0 else 'no')
