import sys

def solution():
    title_num, character_num = map(int, input().split())
    titles_hash = {}
    titles = []
    for _ in range(title_num):
        name, limit = sys.stdin.readline().strip().split()
        limit = int(limit)
        if limit not in titles_hash:
            titles_hash[limit] = name
            titles.append(limit)

    titles.sort()

    for _ in range(character_num):
        power = int(sys.stdin.readline().strip())
        left = 0
        right = len(titles) - 1
        while left < right:
            mid = (left + right) // 2

            if titles[mid] < power:
                left = mid + 1
            else:
                right = mid

        print(titles_hash[titles[left]])
solution()