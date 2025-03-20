def solution(picks, minerals):
    answer = 0
    # 곡갱이를 새로 사용해야하는 시점에서 어떤 곡갱이를 쓸지는
    # 앞으로의 5개의 광물을 채굴하면서 소요되는 피로도의 최솟값을 사용해야한다.
    # 여기서 피로도가 같을 경우 돌 -> 철 -> 다이아 순으로 사용한다.
    # n(3) * m(5) * len(minerals) // 5
    # len(minerals) % 5 는 다이아 -> 철 -> 돌 순으로 한다.
    # picks = [dia, iron, stone]
    pick_nums = sum(picks)
    pick_available = pick_nums * 5
    
    if pick_available < len(minerals):
        minerals = minerals[:pick_available]
    
    ## dia, iron, stone
    split_mienerals_to_five = [[0, 0, 0] for _ in range(pick_nums + 1)]
    
    for i in range(len(minerals)):
        if minerals[i] == "diamond":
            split_mienerals_to_five[i // 5][0] += 1
        elif minerals[i] == "iron":
            split_mienerals_to_five[i // 5][1] += 1
        else:
            split_mienerals_to_five[i // 5][2] += 1

    ## reverse로 람다 대체
    split_mienerals_to_five.sort(reverse = True)

    for i in range(pick_nums):
        d, i, s = split_mienerals_to_five[i]
        if picks[0] > 0:
            answer += (d + i + s)
            picks[0] -= 1
            
        elif picks[1] >0:
            answer += (5 * d + i + s)
            picks[1] -= 1
        else:
            answer += (25 * d + 5 * i + s)
            picks[2] -= 1
            
    # print(min_energy)
    return answer