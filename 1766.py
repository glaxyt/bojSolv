# 1766번 문제집
# 주어진 문제는 모두 풀어야한다.
# 문제를 푸는 순서가 주어졌다.(문제들을 가장 풀기 쉬운 루트를 구축하자)
# 문제를 푸는데 정해진 순서는 최대한 오름차순으로 구성한다. - heapq를 사용한다.
# 여기서 위상정렬 문제임을 알아냄.

# 조건에 만족하는 문제를 최대한 끌어낸 뒤 남은 문제는 오름차순으로 정렬한다.
import sys
import heapq

n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n)]
numOfEdges = [0 for _ in range(n)]
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a-1].append(b-1)
    numOfEdges[b-1] += 1

queue = []

# 진입차수가 없는 경우. 초기값 설정
# 그러나 진출차수가 존재하지않는 노드일 수도 있다.
# 그래서 heap에 1)진출차선이 존재하지만 진입차선이 0인 노드 2) 진출차선, 진입차선이 0개인 노드를
# 모두 집어넣어서 오름차순으로 뽑아낼 수 있게 세팅해준다. 참고로 heap은 최소힙이 기본 세팅이다.
for i in range(n):
    if numOfEdges[i] == 0:
        heapq.heappush(queue, i)

ans = []
while queue:
    c_n = heapq.heappop(queue)
    ans.append(c_n+1)
    for i in graph[c_n]:
        numOfEdges[i] -= 1
        if numOfEdges[i] == 0:
            heapq.heappush(queue, i)

print(*ans)
        
