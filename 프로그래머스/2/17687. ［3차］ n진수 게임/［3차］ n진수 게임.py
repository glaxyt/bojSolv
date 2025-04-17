def make_jinbeop(i, n):
    jinbeop_string = "0123456789ABCDEF"
    result = ""
    if i == 0:
        return '0'
    
    while i:
        result = jinbeop_string[i % n] + result
        i //= n
        
    return result

def solution(n, t, m, p):
    answer = ''
    total = ""
    for i in range(t*m):
        total += make_jinbeop(i, n)

    for i in range(p-1, t*m, m):
        print(p*i-1)
        answer += total[i]

    return answer