def solution():
  h, w, n, m = map(int, input().split())

  row = w // (m + 1)
  if w % (m + 1) > 0:
    row += 1
  
  col = h // (n + 1)
  if h % (n + 1) > 0:
    col += 1

  print(row * col)

solution()