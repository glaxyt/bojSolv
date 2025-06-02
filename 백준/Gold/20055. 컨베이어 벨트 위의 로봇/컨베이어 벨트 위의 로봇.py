def solution():
    n, k = map(int, input().split())
    belt = list(map(int, input().split()))
    robot = [False for _ in range(len(belt))]
    start = 0
    belt_len = len(belt)
    answer = 0

    while True:
        answer += 1

        # 시작하기 전에 벨트 끝에 있는 로봇은 무조건 내림
        start = (start - 1) % (2 * n)
        end = (start + n - 1) % (2 * n)
        robot[end] = False

        # 로봇을 다음 칸으로 회전시킨다.
        for i in range(n - 2, -1, -1):
            cur = (i + start) % belt_len
            move = (cur + 1) % belt_len
            if robot[cur] and not robot[move] and belt[move] > 0:
                robot[cur] = False
                robot[move] = True
                belt[move] -= 1
        robot[end]  = False

        # 로봇이 시작 지점에 존재하지 않는다면 로봇을 올린다.
        if not robot[start] and belt[start] > 0:
            robot[start] = True
            belt[start] -= 1

        if belt.count(0) >= k:
            print(answer)
            break

solution()

