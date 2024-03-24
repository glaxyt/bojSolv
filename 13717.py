# 13717번 포켓몬 GO
n = int(input())
li = []
alltotal = 0
for i in range(n):
    name = input()
    evol, candy = map(int, input().split())
    total = 0
    while evol <= candy:
        upgrade_pocketmon = (candy // evol)
        candy %= evol
        candy += (upgrade_pocketmon) * 2
        total += upgrade_pocketmon

    alltotal += total  
    li.append([total, -i, name])

li.sort(reverse=True)
print(alltotal)
print(li[0][2])

