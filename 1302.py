# 1302번 베스트셀러
import sys
input = sys.stdin.readline
n = int(input())
books = []
set_a = []
for _ in range(n):
    book = input()
    books.append(book)
    if book not in set_a:
        set_a.append(book)

set_a.sort()        
ans = ''
maximum = 0
for i in set_a:
    if maximum < books.count(i):
        maximum = books.count(i)
        ans = i
print(ans)
    
