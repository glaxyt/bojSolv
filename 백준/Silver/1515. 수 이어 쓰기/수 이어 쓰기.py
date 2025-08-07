seq = list(input())

cur_num = 1
str_num = ["1"]

for i in range(len(seq)):
    while True:
        if seq[i] in str_num:
            str_num = str_num[str_num.index(seq[i]) + 1:]
            break
        cur_num += 1
        str_num = list(str(cur_num))

print(cur_num)
