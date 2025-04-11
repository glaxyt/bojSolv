n = int(input())
for _ in range(n):
    stock_num = int(input())
    stocks = list(map(int, input().split()))
    max_stock = stocks.pop()
    profit = 0
    while stocks:
        cur_stock = stocks.pop()
        if cur_stock >= max_stock:
            max_stock = cur_stock
        else:
            profit += (max_stock - cur_stock)

    print(profit)
        