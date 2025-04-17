def gcd(a, b):
    while b:
        a, b = b, a % b
        
    return a

def lcm(a, b):
    return a * b // gcd(a, b)

def solution(arr):
    n = len(arr)
    if n == 1:
        return arr[0]

    temp = arr[0]
    for i in range(1, n):
        temp = lcm(temp, arr[i])
        
    return temp