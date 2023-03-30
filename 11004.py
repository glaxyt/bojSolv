# 11004번 K번째
N, K = map(int, input().split())
arr = sorted(list(map(int, input().split())))
print(arr[K-1])
