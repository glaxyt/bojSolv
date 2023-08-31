# 1062번 가르침
import sys
from itertools import combinations
input = sys.stdin.readline

n, k = map(int, input().split())
words = [sys.stdin.readline().rstrip() for _ in range(n)]

basic = set(["a", "c", "i", "t", "n"])
unlearned = set(chr(i+ord("a")) for i in range(26)) - basic
ans = 0

learned = [0] * 26
for i in basic:
    learned[ord(i)-ord("a")] = 1
    
def count_words(li):
    cnt = 0
    learned = li

    for word in words:
        flag = True
        for i in word:
            if learned[ord(i)-ord("a")] == 0:
                flag = False
                break
        if flag:
            cnt += 1
    return cnt
            

if k < 5:
    print(0)
else:           
    for new_word in combinations(unlearned, k-5):
        for i in new_word:
            learned[ord(i)-ord("a")] = 1
        ans = max(ans, count_words(learned))
        for i in new_word:
            learned[ord(i)-ord("a")] = 0
    print(ans)
