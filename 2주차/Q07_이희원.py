score = input()
length = len(score)
result1 = 0
result2 = 0

for i in range(length // 2):
    result1 += int(score[i])

for j in range(length // 2, length):
    result2 += int(score[j])
    
if (result1 == result2):
    print("LUCKY")

else:
    print("READY")