from itertools import permutations

def solution(n, weak, dist):
    length = len(weak)
    weak_extended = weak + [w + n for w in weak]
    answer = len(dist) + 1

    for start in range(length):
        for friends in permutations(dist):
            count = 1
            position = weak_extended[start] + friends[0]

            for idx in range(start, start + length):
                if weak_extended[idx] > position:
                    count += 1
                    if count > len(dist):
                        break
                    position = weak_extended[idx] + friends[count - 1]
            answer = min(answer, count)

    return answer if answer <= len(dist) else -1
