import sys
from operator import truediv

sys.setrecursionlimit(10000)

answer = []

def solution():
    t = int(input())

    for _ in range(t):
        n = int(input())
        make_form(n, "1", 2)
        print("\n".join(sorted(answer)))
        answer.clear()
        print()

def make_form(n: int, formula: str, idx: int):
    if idx == n + 1:
        if calculate(formula) == 0:
            answer.append(formula)
        return

    make_form(n, formula + "+" + str(idx), idx + 1)
    make_form(n, formula + "-" + str(idx), idx + 1)
    make_form(n, formula + " " + str(idx), idx + 1)

def calculate(formula: str):
    formula = formula.replace(" ", "")
    idx = 0

    result = 0
    while idx < len(formula) and formula[idx] != "+" and formula[idx] != "-":
        result = result * 10 + int(formula[idx])
        idx += 1

    temp = 0
    while idx < len(formula):
        ops = formula[idx]
        idx += 1
        while idx < len(formula) and formula[idx] != "+" and formula[idx] != "-":
            temp = temp * 10 + int(formula[idx])
            idx += 1
        if ops == "+":
            result += temp
        else:
            result -= temp
        temp = 0
    return result

solution()
