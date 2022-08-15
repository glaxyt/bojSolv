# 2231번 분해합
decomposition = int(input())

# 0에서부터 분해합(N)까지의 모든 정수의 분해합을 출력하여
# N과 같은 숫자가 나오면 생성자를 찾게 됩니다.
for i in range(decomposition):
    temp = list(map(int, str(i)))
    total = i + sum(temp)
    if total == decomposition:
        print(i)
        exit(0)
print(0)
