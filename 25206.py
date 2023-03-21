# 25206번 너의 평점은
import sys
input = sys.stdin.readline

total_score = 0
total_grade = 0
score_dic = {"A+": 4.5, "A0":4.0, "B+":3.5, "B0":3.0, "C+":2.5, "C0":2.0, "D+":1.5, "D0":1.0, "F":0.0}

for _ in range(20):
    subject, grade, score = input().rstrip().split()
    if score == "P":
        continue
    else:
        total_score += (float(grade) * score_dic[score])
        total_grade += float(grade)

ans = total_score/total_grade
print(f"{ans:.6f}")
        
