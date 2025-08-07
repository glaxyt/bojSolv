n = int(input())
initial = list(map(int, input()))  # 초기 상태를 int 리스트로 변환 (0 또는 1)
target = list(map(int, input()))  # 목표 상태를 int 리스트로 변환


# 상태 반전 함수 (0 <-> 1)
def flip(state, idx):
    if 0 <= idx < n:
        state[idx] = 1 - state[idx]


# 한 가지 경우를 시뮬레이션하는 함수
# start_flip: 첫 스위치를 누르는지 여부 (True/False)
def simulate(start_flip):
    state = initial[:]  # 초기 상태 복사
    count = 0  # 스위치 누른 횟수

    if start_flip:
        # 첫 스위치 누르기: 0번과 1번 전구 반전
        flip(state, 0)
        flip(state, 1)
        count += 1

    for i in range(1, n):
        # 이전 전구(i-1)가 목표와 다르면 현재 스위치(i) 누르기
        if state[i - 1] != target[i - 1]:
            # i번 스위치: i-1, i, i+1 반전 (i-1은 존재 보장)
            flip(state, i - 1)
            flip(state, i)
            if i + 1 < n:
                flip(state, i + 1)
            count += 1

    # 마지막에 전체 상태가 목표와 맞는지 확인
    if state == target:
        return count
    else:
        return float('inf')  # 불가능하면 무한대 반환


# 두 경우 실행
case1 = simulate(False)  # 첫 스위치 안 누름
case2 = simulate(True)  # 첫 스위치 누름

# 최소값 구하기, 둘 다 불가능하면 -1
min_count = min(case1, case2)
if min_count == float('inf'):
    print(-1)
else:
    print(min_count)
