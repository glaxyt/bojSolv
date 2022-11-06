# 5597번 과제 안 내신 분..?
attendence = set(range(1, 31))
student = set()
for i in range(28):
    student.add(int(input()))

ans = attendence - student
ans = sorted(list(ans))

for i in ans:
    print(i)
