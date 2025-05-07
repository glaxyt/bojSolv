# 13:14 시작
from collections import deque
ROOM_NUM = 5
dxys = ((0, 1), (1, 0), (-1, 0), (0, -1))

def solution(places):
    answer = []
    # 맨해튼 거리가 무엇인가요: |x1-x2| + |y1-y2|
    # 모든 정점에서 모든 정점까지의 최소 거리를 계산한다.
    answer = []
    
    for place in places:
        if check_waiting_room(place):
            answer.append(1)
        else:
            answer.append(0)
                        
    return answer

def check_waiting_room(place):
    for x in range(ROOM_NUM):
        for y in range(ROOM_NUM):
            if place[x][y] == 'P':
                if not bfs(x, y, place):
                    return False
    return True

def bfs(sx, sy, place):
    queue = deque()
    queue.append((sx, sy, 0))  # (x, y, depth)
    visited = [[False]*ROOM_NUM for _ in range(ROOM_NUM)]
    visited[sx][sy] = True

    while queue:
        x, y, dist = queue.popleft()

        if 0 < dist <= 2 and place[x][y] == 'P':
            return False  # 거리 2 이내에 다른 사람 발견

        if dist >= 2:
            continue  # 더 이상 탐색하지 않음

        for dx, dy in dxys:
            nx, ny = x + dx, y + dy

            if 0 <= nx < ROOM_NUM and 0 <= ny < ROOM_NUM and not visited[nx][ny]:
                if place[nx][ny] != 'X':  # 파티션은 탐색 불가
                    visited[nx][ny] = True
                    queue.append((nx, ny, dist + 1))

    return True


# def bfs(sx, sy, place):
#     queue = deque([[sx, sy]])
#     visited = [[0 for _ in range(ROOM_NUM)] for _ in range(ROOM_NUM)]
#     visited[sx][sy] = 1
    
#     while queue:
#         cx, cy = queue.popleft()
        
#         for dx, dy in dxys:
#             nx = cx + dx
#             ny = cy + dy
            
#             if not (0 <= nx < ROOM_NUM and 0 <= ny < ROOM_NUM):
#                 continue
                
#             if (place[nx][ny] == 'X' and visited[nx][ny]):
#                 continue
                
#             visited[nx][ny] = visited[cx][cy] + 1
            
#             if place[nx][ny] == 'P' and visited[nx][ny] < 4:
#                 return False
            
#             queue.append([nx, ny])
            
#     return True
            
            