answer = []
while True:
  n = input()
  if n == "0":
    break
  
  answer.append([n])
  while int(n) // 10 > 0 and len(n) > 1:
    result = int(n[0])

    for i in range(1, len(n)):
      result *= int(n[i])

    answer[-1].append(result)
    n = str(result)

for li in answer:
  print(*li)