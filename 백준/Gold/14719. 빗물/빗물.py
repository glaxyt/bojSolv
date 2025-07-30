def solution():
    n, w = map(int, input().split())
    height = list(map(int, input().split()))

    answer = 0
    left_idx = 0
    right_idx = w - 1

    for i in range(w):
        if height[i] >= height[left_idx]:

            for j in range(left_idx, i):
                answer += (height[left_idx] - height[j])

            left_idx = i

        else:
            if i == w - 1:
                for j in range(w - 1, left_idx, -1):
                    if height[j] < height[right_idx]:
                        answer += (height[right_idx] - height[j])
                    else:
                        right_idx = j
    print(answer)

solution()
