# 12015번 가장 긴 증가하는 부분 수열 2
n = int(input())
nums = list(map(int, input().split()))

# 내가 관심이 있는건 수열에 새로운 숫자를 추가하기 위해서는
# 수열의 마지막 숫자의 크기만이 중요하다. 그 이전의 존재하는 숫자의 크기는 상관없다.
def bin_sec(target):
    start = 0
    end = len(dp)-1
    while start <= end:
        mid = (start+end) // 2
        # 중복된 숫자가 들어왔을 경우 dp리스트에 원래 있던 자리에 그대로 넣어준다.
        if dp[mid] == target:
            return mid
        elif dp[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    # 숫자를 넣기 적절한 위치
    return start

dp = [nums[0]]

for i in nums:
    if dp[-1] < i:
        dp.append(i)
    else:
        idx = bin_sec(i)
        dp[idx] = i

print(len(dp))
