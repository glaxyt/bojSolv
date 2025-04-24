
def solution(people, limit):
    people.sort()  # 몸무게를 정렬 (오름차순)
    answer = 0  # 필요한 보트 개수
    right = len(people) - 1
    left = 0
    
    while right >= left:
        if people[left] + people[right] <= limit:
            left += 1
        right -= 1
        answer += 1
            
    return answer
