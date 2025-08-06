def solution():
    n = int(input())
    nums = [0] * (n + 1)
    for i in range(1, n+1):
        nums[i] = int(input())

    answer = set()

    def dfs(first: set, second: set, idx):
        first.add(idx)
        second.add(nums[idx])

        if nums[idx] in first:
            if first == second:
                answer.update(first)
                return True
            return False

        return dfs(first, second, nums[idx])

    for i in range(1, n+1):
        if i not in answer:
            dfs(set(), set(), i)

    result = sorted(list(answer))
    print(len(result))
    for num in result:
        print(num)

solution()