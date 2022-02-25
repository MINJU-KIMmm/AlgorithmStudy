n = int(input())

location = list(map(int, input().split()))

temp = []
result = []
final = 0
distance = 0

for i in range(n):
    for j in range(n):
        distance = abs(location[i] - location[j])
        temp.append(distance)
    result.append(sum(temp))
    temp = []

tmp = min(result)
final = result.index(tmp)

print(location[final])