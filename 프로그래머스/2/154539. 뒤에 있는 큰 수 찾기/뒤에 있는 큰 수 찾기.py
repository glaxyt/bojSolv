def solution(numbers):
    n = len(numbers)
    answer = [-1] * n
    stack = []

    for i in range(n - 1, -1, -1):
        num = numbers[i]

        # 자기보다 작거나 같은 수는 뺀다
        while stack and stack[-1] <= num:
            stack.pop()

        # 스택이 비어있지 않으면 뒷 큰수
        if stack:
            answer[i] = stack[-1]

        stack.append(num)

    return answer
