n = int(input())
tower_h = list(map(int, input().split()))
ans = []
stack = []

for i in range(n):
    while stack:
        # 수신 받을 수 있는 탑 후보 > 송신하는 탑
        if stack[-1][1] > tower_h[i]:
            ans.append(stack[-1][0])
            break
        else:
            stack.pop()
    if not stack:
        ans.append(0)
    stack.append([i+1, tower_h[i]])

print(" ".join(map(str, ans)))