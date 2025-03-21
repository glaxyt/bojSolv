def solution(users, emoticons):
    answer = [0, 0]
    ## 탐욕법을 사용해야하는가? 라는 고민이 들었다.
    ## 목표 : 1 이모티콘 플러스 서비스 가입자를 늘리는것
    ## 2. 이모티콘 판매액을 최대한 늘리는 것.
    ## n명의 카카오톡 사용자들에게 m개를 할인하여 판매
    ## 이모티콘마다 할인율은 다르다.
    ## 
    ## 사용자들의 관점
    ## 사용자들은 자신의 기준에 따라 일정 비율 이상 할인하는 이모티콘을 모두 구매한다.
    ## 이모티콘 구매의 합이 일정 가격 이상이 되면 구매 취소 후 플러스 가입한다.
    ## '개별로 살 바에는 구독한다.'
    ## 첫 기준은 어디로 잡아야하나. 비율 중 제일 최댓값 찾기 
    ## 예시 2번으로 해보자.
    ## 할인율 40이 최대. 할인율 40으로 설정하면 모두가 구독을 하지않고 이모티콘을 구매한다.
    ## 할인율은 10%, 20%, 30%, 40% 중 하나로 설정됩니다.
    ## 제일 원가가 비싼 애들을 할인율을 먼저 낮추면 된다. 그러면 판매 금액을 많이 늘릴 수 있다.
    ## 할인율 5%는?
    ## 플러스 가입자의 사람 수를 제일 많이 늘리고, 수익도 늘려야한다.
    ## 모두 10%로 시작 -> 그러고 나서 싼 애들부터 10%만들기

#     for i in range(n):
#         discounted_emoticons.append(int(emoticons[i] * 0.9))
    
#     discounted_emoticons.sort()
    
#     for peo in range(len(users)):
#         peo_purchase = []
#         for dis in [10. 20, 30, 40]:
    users_ans = [0 for _ in range(len(users))]
    ## n제곱은 안돼... 제발
    ## 그렇다며 어떻게 해야할까?
    fee_comb = []
    fee = []
    emoticons_length = len(emoticons)
    fee_list = [10, 20, 30, 40]
    def calc_fee(cnt):
        if cnt == emoticons_length:
            fee_comb.append(fee[:])
            return
        
        for cur_idx in range(4):
            fee.append(fee_list[cur_idx])
            calc_fee(cnt + 1)
            fee.pop()
        
    
    calc_fee(0)
    for i in range(len(fee_comb)):
        subscribe = 0
        total_spend = 0
        for user_idx in range(len(users)):
            user_spend = 0
            
            for idx in range(len(fee_comb[i])):
                discount = fee_comb[i][idx]
                
                if users[user_idx][0] <= discount:
                    user_spend += (1 - discount / 100) * emoticons[idx]
                    # print(discount, users[user_idx][0], emoticons[idx], user_spend)
                    
            if users[user_idx][1] <= user_spend:
                subscribe += 1
            else:
                total_spend += user_spend
        
        if subscribe > answer[0]:
            answer = [subscribe, total_spend]
        elif subscribe == answer[0]:
            if total_spend > answer[1]:
                answer = [subscribe, total_spend]
                
    

                
                    
                    
        
        
#         for i in range((min_dis // 10 + 1) * 10, 41, 10)
#             for user in emoticons:
#             ## 10
            
#             ## 모든 이모티콘
#             ## 모두 가격 할인 한번씩 해보기
            
    
    return answer