# 1076번 저항
a = input()
b = input()
c = input()
resist = {'black': 0, 'brown': 1, 'red': 2, 'orange': 3,
             'yellow': 4, 'green': 5, 'blue': 6, 'violet': 7,
             'grey': 8, 'white': 9}
 
print((resist[a] * 10 + resist[b]) * (10 ** resist[c]))
