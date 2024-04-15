# 1417번 국회의원 선거
import sys
from heapq import heappop, heappush, heapify

n = int(input())
dasom_vote = int(input())
votes = [] 
for _ in range(n-1):
    vote = int(sys.stdin.readline())
    votes.append([-vote, vote]
                 )
heapify(votes)

def compare_dasom():
    for i in range(n-1):
        # 다솜의 표가 적어도 하나의 후보자의 표보다 적거나 같은 경우
        if dasom_vote <= votes[i][1]:
            return True
    # 다른 각각의 후보자의 표보다 다솜의 표가 더 많은 경우 -> 매수 종료
    return False


ans = 0
if not votes:
    print(ans)
else:
    while compare_dasom():
        competition_vote = heappop(votes)[1]
        competition_vote -= 1
        heappush(votes, [-competition_vote, competition_vote])
        dasom_vote += 1
        ans += 1

    print(ans)
