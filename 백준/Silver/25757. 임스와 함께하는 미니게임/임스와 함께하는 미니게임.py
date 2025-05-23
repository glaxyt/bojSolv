plays = {'Y': 1, 'F': 2, 'O': 3}

def solution():
    n, game_type = input().split()
    n = int(n)
    people = set()
    for _ in range(n):
        people.add(input())
  
    print(len(people) // plays[game_type])


solution()