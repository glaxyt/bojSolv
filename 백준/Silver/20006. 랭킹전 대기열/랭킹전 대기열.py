import sys

def solution():
    p, m = map(int, input().split())
    # 방의 레벨 제한 키: 순서, [레벨, 인원 수]
    room_info = dict()
    # 방에 누가 있는지 키: 순서, 누가있는지
    room_players = dict()
    idx = 0
    # 방은 생성순, 플레이어는 사전순
    for _ in range(p):
        level, name = input().split()
        level = int(level)
        is_join = False
        for key in room_info.keys():
            limit_level = room_info[key][0]
            room_player_numb = room_info[key][1]
            if room_player_numb == m:
                continue
            if limit_level - 10 <= level <= limit_level + 10:
                room_info[key][1] += 1
                room_players[key].append([level, name])
                is_join = True
                break
        if not is_join:
            idx += 1
            room_info[idx] = [level, 1]
            room_players[idx] = []
            room_players[idx].append([level, name])

    keys = sorted(list(room_info.keys()))
    for key in keys:
        _, player_num = room_info[key]
        if player_num == m:
            print("Started!")
        else:
            print("Waiting!")
        for player_info in sorted(room_players[key], key=lambda x : x[1]):
            print(*player_info)
    
solution()