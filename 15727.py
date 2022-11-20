# 15727번 조별과제를 하려는데 조장이 사라졌다
n = int(input())

ans = 0
while n > 0:
    n -= 5
    ans += 1
    
print(ans)
