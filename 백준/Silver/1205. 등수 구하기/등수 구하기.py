
def solution():
    # 하지만, 같은 점수가 있을 때는 그러한 점수의 등수 중에 가장 작은 등수가 된다.
    ## 90, 90, 90인 3명이 존재할 경우 가장 높은 등수를 적어준다.

    n, taesoo, p = map(int, input().split())

    if n > 0:
        scores = list(map(int, input().split()))
    else:
        print(1)
        return
    # 만약, 랭킹 리스트가 꽉 차있을 때, 새 점수가 이전 점수보다 더 좋을 때만 점수가 바뀐다.
    ## 이 말은 태수의 점수가 랭킹의 가장 낮은 점수보다 무조건 높아야한다.
    # 만약 태수의 점수가 랭킹 리스트에 올라갈 수 없을 정도로 낮다면 -1을 출력한다.

    # 출력 등수보다 적은 참여자가 존재한다면.
    if n < p:
        for rank, score in enumerate(scores, 1):
            if taesoo >= score:
                print(rank)
                return
        print(n + 1)
        return
    else:
        if taesoo > scores[p-1]:
            for rank, score in enumerate(scores[:p], 1):
                if taesoo >= score:
                    print(rank)
                    break
        else:
            print(-1)

solution()