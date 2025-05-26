def solution():
  t = int(input())

  for _ in range(t):
    n = int(input())
    ranks = list(map(int, input().split()))

    ans = -1
    min_score = 1201
    can_team = set()
    teams = dict()
    team_player_count = dict()  # 팀별 현재까지 들어온 사람 수

    # 6명 완주한 팀만 후보
    for team_id in set(ranks):
      if ranks.count(team_id) == 6:
        can_team.add(team_id)

    idx = 0  # 등수 (1부터 시작)
    for team in ranks:
      if team not in can_team:
        continue

      idx += 1

      if team not in teams:
        teams[team] = [0, 0]  # [점수합, 다섯 번째 선수 등수]
        team_player_count[team] = 1
        teams[team][0] += idx  # 1번째 선수 점수 포함
      else:
        team_player_count[team] += 1
        count = team_player_count[team]
        if count <= 4:
          teams[team][0] += idx  # 1~4번째 선수 점수 포함
        elif count == 5:
          teams[team][1] = idx  # 다섯 번째 선수 등수 기록

    for team in teams.keys():
      score, fifth_runner = teams[team]
      if score < min_score:
        ans = team
        min_score = score
      elif score == min_score:
        if teams[ans][1] > fifth_runner:
          ans = team

    print(ans)

solution()
