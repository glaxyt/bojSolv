def solution():
    t = int(input())
    for _ in range(t):
        n, m, k = map(int, input().split())
        answer = 0

        if m * k == 0 or (m == 1 and k == 1 and n > 1):
            print(-1)
            continue

        n -= (m * k)
        answer += 1

        # 부족한 우산을 보충합니다. 언제까지? 한 사람이 희생해서 가져와야합니다.
        while n > 0:
            n += 1
            n -= (m * k)
            answer += 2

        print(answer)

solution()