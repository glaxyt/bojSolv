def solution():
    answer = 1
    word = list(input())
    word_length = len(word)
    for k in range(1, word_length + 1):
        if word_length % k == 0:
            # 마지막 문자를 맨 앞으로 옮긴 것과 같아야함
            if compareTwoWord(k, word_length, word):
                answer = k
                break
    print(answer)

def compareTwoWord(k, word_length, word):
    idx = k
    k_word = word[:k]
    while idx - 1 + k  < word_length:
        temp = k_word.pop()
        k_word.insert(0, temp)

        for i in range(k):
            if k_word[i] != word[idx + i]:
                return False

        idx += k

    return True

solution()
