# 3009번 네 번째 점
x_li = []
y_li = []
for _ in range(3):
    x, y = map(int, input().split())
    x_li.append(x)
    y_li.append(y)

for i in range(3):
    if x_li.count(x_li[i]) == 1:
        x_ans = x_li[i]
    if y_li.count(y_li[i]) == 1:
        y_ans = y_li[i]
print(x_ans, y_ans)