from collections import defaultdict
import heapq

def solution(genres, plays):
    answer = []
    # 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범 출시하기 
    # 앨범 노래 수록 기준
    # 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    # 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    # 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    
    ## 참고사항
    # 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
    # 장르 별로 가장 많이 재생된 노래를 저장하는 딕셔너리
    genres_dir = defaultdict(list)
    
    # 장르 별 총 재생 횟수를 저장하는 딕셔너리
    # 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    genre_dir_plays = defaultdict(int)
    for i, genre in enumerate(genres):
        heapq.heappush(genres_dir[genre], (-1 * plays[i], i))
        genre_dir_plays[genre] += plays[i]

    sorted_genres = sorted(genre_dir_plays.keys(), key=lambda x: genre_dir_plays[x], reverse=True)

    for genre in sorted_genres:
        count = 0
        while genres_dir[genre] and count < 2:
            answer.append(heapq.heappop(genres_dir[genre])[1])  # (재생 횟수, 고유 번호) 튜플에서 고유 번호 저장
            count += 1
                               
    
    return answer