# 18870 좌표 압축
n = int(input())
nums = list(map(int, input().split()))
# 중복되는 수를 제거해줍니다.
remove_overlap = list(set(nums))
# 오름차순으로 수를 정렬해줍니다.
remove_overlap.sort()
length = len(remove_overlap)
ans_dic = {remove_overlap[i]: i for i in range(length)}

for i in nums:
    print(ans_dic[i], end = " ")
