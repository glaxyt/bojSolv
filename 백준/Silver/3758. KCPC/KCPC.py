from collections import defaultdict

def solution():
    t = int(input())

    for _ in range(t):
        n, k, t, m = map(int, input().split())
        # team_submit_answer = {team: {}}
        team_submit_answer = defaultdict(dict)
        # scores[i] = [total, submit_num, last_submit_time]
        scores = [[0,0,0,i+1] for i in range(n)]
        order = 0
        for _ in range(m):
            team_idx, q_idx, score = map(int, input().split())
            team_idx -= 1
            # 첫 제출 시
            if q_idx not in team_submit_answer[team_idx]:
                team_submit_answer[team_idx][q_idx] = score
                scores[team_idx][0] += score
            else:
                if team_submit_answer[team_idx][q_idx] < score:
                    ex_score = team_submit_answer[team_idx][q_idx]
                    scores[team_idx][0] -= ex_score
                    team_submit_answer[team_idx][q_idx] = score
                    scores[team_idx][0] += score

            scores[team_idx][1] += 1
            scores[team_idx][2] = order
            order += 1

        scores.sort(key = lambda x: (-x[0], x[1], x[2]))
        for rank in range(n):
            if scores[rank][3] == t:
                print(rank + 1)
                break
    
solution()