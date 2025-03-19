from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    
    for c in course:
        comb_count = Counter()
        
        # 각 주문에서 주어진 course 크기만큼 조합을 생성하여 카운팅
        for order in orders:
            comb_count.update(Counter(map(lambda x: ''.join(x), combinations(sorted(order), c))))
        
        # 최댓값 찾기 (최소 2번 이상 등장한 조합만 선택)
        if comb_count:
            max_count = max(comb_count.values())
            if max_count >= 2:
                answer += [menu for menu, count in comb_count.items() if count == max_count]

    return sorted(answer)  # 사전순 정렬
