def solution():
    seq = input()

    slide_length = seq.count('a')
    slide = seq[0:slide_length]
    cur_a_num = slide.count('a')
    answer = cur_a_num

    for start in range(1, len(seq)):
        end = (start + slide_length - 1) % len(seq)
        if seq[end] == 'a':
            cur_a_num += 1
        if seq[start - 1] == 'a':
            cur_a_num -= 1
        answer = max(answer, cur_a_num)

    print(slide_length - answer)
solution()