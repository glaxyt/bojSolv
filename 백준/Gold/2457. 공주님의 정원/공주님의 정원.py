import sys

n = int(sys.stdin.readline())
flowers = []

for _ in range(n):
    sm, sd, em, ed = map(int, sys.stdin.readline().split())
    start = sm * 100 + sd
    end = em * 100 + ed
    flowers.append((start, end))

flowers.sort()

target = 301
end = 1201
idx = 0
count = 0
max_end = 0

while target < end:
    found = False
    # 현재 target 날짜 이전에 피는 꽃 중 가장 멀리까지 커버 가능한 꽃 탐색
    while idx < n and flowers[idx][0] <= target:
        if max_end < flowers[idx][1]:
            max_end = flowers[idx][1]
            found = True
        idx += 1

    if not found:
        print(0)
        sys.exit()

    count += 1
    target = max_end

print(count)
