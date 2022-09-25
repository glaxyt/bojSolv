# 2038번 럭비 클럽
while True:
    person = input().split()

    if person[0] =='#':
        break

    name = person[0]
    age = int(person[1])
    weight = int(person[2])
    
    if age > 17 or weight >= 80:
        print(name, "Senior")
    else:
        print(name, "Junior")
        
