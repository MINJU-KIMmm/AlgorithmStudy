str = input()
alphabet = []
number = 0
num_exist = False

for i in str:
    if i.isalpha():
        alphabet.append(i)
    else:
        number += int(i)
        num_exist = True
alphabet.sort()

if(num_exist):
    for i in range(len(alphabet)):
        print(alphabet[i], end='')
    print(number)
else:
    for i in range(len(alphabet)):
        print(alphabet[i], end='')