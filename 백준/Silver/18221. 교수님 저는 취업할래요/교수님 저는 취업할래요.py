n = int(input())
grid = []
professor = [0, 0]
sunggyu = [0, 0]

def solution():

  def check_five_people_in_area(sx, sy, fx, fy):
    total =0
    if ((professor[0] - sunggyu[0]) ** 2) + ((sunggyu[1] - professor[1]) ** 2) < 25:
      return 0

    if sx > fx:
      sx, fx = fx, sx

    if sy > fy:
      sy, fy = fy, sy
      
    for i in range(sx, fx + 1):
      for j in range(sy, fy + 1):
        if grid[i][j] == '1':
          total += 1

    return total

  for i in range(n):
    li = input().split()
    grid.append(li)
    for j in range(n):
      if li[j] == '5':
        professor = [i, j]

      if li[j] == '2':
        sunggyu = [i, j]

  people_in_area = check_five_people_in_area(professor[0], professor[1], sunggyu[0], sunggyu[1])

  if people_in_area > 2:
    return 1
  return 0

print(solution())

