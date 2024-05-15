# 1135번 뉴스 전하기
num = int(input())
order = list(map(int, input().split()))
tree = [[] for _ in range(num)]
for idx, manager in enumerate(order):
    if idx != 0:
        tree[manager].append(idx)
dp = [0 for _ in range(num)]
def dfs(node):
    node_to_sub = []
    for sub in tree[node]:
        dfs(sub)
        node_to_sub.append(dp[sub])

    node_to_sub.sort(reverse=True)
    if node_to_sub:
        choose_large_time = [amount + idx + 1 for idx, amount in enumerate(node_to_sub)]

        maximum_time = max(choose_large_time)
        dp[node] = maximum_time

dfs(0)
print(dp[0])

