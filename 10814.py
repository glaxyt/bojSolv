# 10814번 나이순 정렬
import sys
s = sys.stdin.readlines()[1:]
s.sort(key=lambda x : int(x.split()[0]))
print(''.join(s))
