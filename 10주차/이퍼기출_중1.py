n = int(input())
score = []

for i in range(1, n+1):
    temp = int(input())
    score.append(temp)

d = [0]*301

d[1] = score[1]
d[2] = score[1] + score[2]

for i in range(3, n+1):
    d[i] = max(score[i] + d[i-3] + score[i-1], score[i] + d[i-2])

print(d[n])