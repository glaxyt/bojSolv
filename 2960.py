# 2960번 에라토스테네스의 체
n, k = map(int, input().split())
arr = [True for _ in range(n+1)]
def findsosu():
    cnt = 0
    for i in range(2, n+1):
        if arr[i]:
            for j in range(i, n+1, i):
                if arr[j] == True:
                    arr[j] = False
                    cnt+=1
                    if cnt == k:
                        return print(j)
                
findsosu()
