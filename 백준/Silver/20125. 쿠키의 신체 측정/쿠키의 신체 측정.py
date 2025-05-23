# 시작 시간 12시 49분
## 첫 제출 1시 22분
def solution():
  n = int(input())
  grid = [list(input()) for _ in range(n)]
  # 두 번째 줄에는 각각 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리의 길이를 공백으로 구분해서 출력하여라.
  answer = []
  center_x, center_y = 0, 0
  for i in range(n - 1):
    for j in range(n - 1):
      if grid[i][j] == '*':
        if grid[i][j + 1] == '*' and grid[i][j - 1] == '*' and grid[i - 1][j] == '*' and grid[i + 1][j] == '*':
          center_x, center_y = i, j
          break

  len_left = 0
  for y in range(center_y - 1, -1, -1):
    if grid[center_x][y] == '*':
      len_left += 1
    else:
       break
  answer.append(len_left)

  len_right = 0
  for y in range(center_y + 1, n):
    if grid[center_x][y] == '*':
      len_right += 1
    else:
       break  
  answer.append(len_right)

  left_leg_x, left_leg_y = 0, 0

  len_back = 0
  for x in range(center_x + 1, n):
    if grid[x][center_y] == '*':
      len_back += 1
    else:
      left_leg_x, left_leg_y = x, center_y - 1
      break  
  answer.append(len_back)

  len_left_leg = 0
  for x in range(left_leg_x, n):
    if grid[x][left_leg_y] == '*':
      len_left_leg += 1
    else:
      break
  answer.append(len_left_leg)

  len_right_leg = 0
  for x in range(left_leg_x, n):
    if grid[x][left_leg_y + 2] == '*':
      len_right_leg += 1
    else:
      break
  answer.append(len_right_leg)
  print(center_x + 1, center_y + 1)
  print(*answer)

solution()
        

    