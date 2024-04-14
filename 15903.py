# 15903번 카드 합체 놀이
from heapq import heappush, heappop, heapify
n , m = map(int, input().split())
cards = list(map(int, input().split()))
heapify(cards)

for _ in range(m):
    card1 = heappop(cards)
    card2 = heappop(cards)
    heappush(cards, card1+card2)
    heappush(cards, card1+card2)

print(sum(cards))
