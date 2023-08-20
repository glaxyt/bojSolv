# 1253번 좋다
n = int(input())
li = sorted(list(map(int, input().split())))
ans = 0

# 두 수의 합을 표현해줄 숫자를 순차적으로 뽑아준다. 
for i in range(n):
    target = li[i]
    start = 0
    end = n-2
    new_li = li[:i] + li[i+1:]
    while start < end:
        total = new_li[start] + new_li[end]
        # 두 수의 합이 target을 만족시키면 ans += 1 후 다음 수 실
        if total == target: 
            ans += 1
            break
        if total >= target:
            end -= 1
        else:
            start += 1

print(ans)
    
