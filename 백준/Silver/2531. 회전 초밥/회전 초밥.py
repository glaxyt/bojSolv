# 회전초밥

n, d, k, c = map(int, input().split())
sushi = []
count = dict()
count[c] = 0
unique = 0

## 초밥 세팅
for _ in range(n):
  sushi.append(int(input()))

## 딕셔너리 초기화
for i in range(n):
  count[sushi[i]] = 0

# 원형 배열로 변경
sushi = sushi + sushi[:k+1]

## 초기 범위만큼 초밥 세팅
for i in range(k):
  if count[sushi[i]] == 0:
    unique += 1
  count[sushi[i]] += 1

if count[c] == 0:
  answer = unique + 1
else:
  answer = unique

## 쿠폰이 들어간다면 어떻게 계산할건가요.?
## 쿠폰이 현재 윈도우에 없다면 보정해주기
for i in range(n):
  ## 한칸 씩 밀기
  ## 벨트 안에 무조건 제외하는 것들
  remove = sushi[i]
  count[remove] -= 1

  ## 배열 안에 있는 값이 삭제 될 경우에만
  if count[remove] == 0:
    unique -= 1

  add = sushi[i+k]
  if count[add] == 0:
    unique += 1

  count[add] += 1

  if count[c] == 0:
    answer = max(answer, unique + 1)
  else:
    answer = max(answer, unique)

print(answer)


  

