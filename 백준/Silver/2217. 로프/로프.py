n = int(input())
ropes = [int(input()) for _ in range(n)]
ropes.sort()
answer = []
for r in ropes:
    answer.append(r * n)
    n -= 1

print(max(answer))