from collections import defaultdict

def solution():

    while True:
        n = int(input())
        if n == 0:
            break

        blank_length = 0
        teams = []
        ranking = dict()
        teams_result = dict()
        team_record = defaultdict(lambda: defaultdict(lambda: "   "))
        for i in range(n):
            team = input()
            teams.append(team)
            teams_result[team] = {"w" : 0, "l": 0, "d" : 0, "goal": 0, "goaled": 0}
            # 점수, 골득실차, 총 득점, 승리 수, 인덱스, 팀이름
            ranking[team] = [0, 0, 0, 0, i, team]
            blank_length = max(blank_length, len(team))

        t = int(input())
        for _ in range(t):
            # Slavia - Arsenal 2:0
            home, _, away, score = input().split()
            team_record[home][away] = score
            home_goal, away_goal = map(int, score.split(":"))
            teams_result[home]["goal"] += home_goal
            teams_result[home]["goaled"] += away_goal
            teams_result[away]["goal"] += away_goal
            teams_result[away]["goaled"] += home_goal

            ranking[home][1] += home_goal - away_goal
            ranking[away][1] += away_goal - home_goal
            ranking[home][2] += home_goal
            ranking[away][2] += away_goal

            if home_goal > away_goal:
                teams_result[home]["w"] += 1
                teams_result[away]["l"] += 1
                ranking[home][0] += 3
                ranking[home][3] += 1

            elif home_goal < away_goal:
                teams_result[home]["l"] += 1
                teams_result[away]["w"] += 1
                ranking[away][0] += 3
                ranking[away][3] += 1

            else:
                teams_result[home]["d"] += 1
                teams_result[away]["d"] += 1
                ranking[home][0] += 1
                ranking[away][0] += 1

        print("RESULTS:")
        print(f'+{"-" * blank_length}+', end= "")
        print("---+" * len(teams))

        # |         |Sla|Ars|Ste|FCS|
        print(f'|{" " * blank_length}|', end= "")
        for team in teams:
            abbrev = team[:3].ljust(3)  # 항상 3칸 폭 유지
            print(f"{abbrev}|", end="")
        print()
        print(f'+{"-" * blank_length}+', end="")
        print("---+" * len(teams))

        for home in teams:
            print(f'|{home:<{blank_length}}|', end="")
            for away in teams:
                if home == away:
                    print(" X |", end="")
                else:
                    print(f"{team_record[home][away]}|", end="")
            print()
            print(f'+{"-" * blank_length}+', end="")
            print("---+" * len(teams))

        print()
        print("STANDINGS")
        print("----------")

        idx = 1
        ranking = sorted(list(ranking.values()), reverse=True)

        rank_w = len(str(len(ranking))) + 1
        name_w = blank_length

        played_list = []
        win_list = []
        draw_list = []
        lose_list = []
        score_list = []
        points_list = []

        for team_info in ranking:
            team = team_info[5]
            w = teams_result[team]["w"]
            l = teams_result[team]["l"]
            d = teams_result[team]["d"]
            gs = teams_result[team]["goal"]
            gc = teams_result[team]["goaled"]
            played = w + l + d
            pts = team_info[0]

            played_list.append(len(str(played)))
            win_list.append(len(str(w)))
            draw_list.append(len(str(d)))
            lose_list.append(len(str(l)))
            score_list.append(len(f"{gs}:{gc}"))
            points_list.append(len(str(pts)))

        played_w = max(played_list) if played_list else 1
        win_w = max(win_list) if win_list else 1
        draw_w = max(draw_list) if draw_list else 1
        lose_w = max(lose_list) if lose_list else 1
        score_w = max(score_list) if score_list else 3
        points_w = max(points_list) if points_list else 1

        idx = 1
        for team_info in ranking:
            team = team_info[5]
            w = teams_result[team]["w"]
            l = teams_result[team]["l"]
            d = teams_result[team]["d"]
            gs = teams_result[team]["goal"]
            gc = teams_result[team]["goaled"]
            played = w + l + d
            pts = team_info[0]

            score_str = f"{gs}:{gc}"
            print(
                f"{str(idx) + '.':>{rank_w}} "
                f"{team:<{name_w}} "
                f"{played:>{played_w}} "
                f"{w:>{win_w}} "
                f"{d:>{draw_w}} "
                f"{l:>{lose_w}} "
                f"{score_str:>{score_w}} "
                f"{pts:>{points_w}}"
            )
            idx += 1
        print()

solution()
