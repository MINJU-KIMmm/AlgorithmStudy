n = int(input())
array = []

for _ in range(n):
    array.append(list(map(int, input().split())))

for i in range(1, n):
        if i == 1:
            array[1][0] += array[0][0]
            array[1][1] += array[0][0]
        else:
            a = 2
            for j in range(a):
                if j == 0:
                    array[i][0] += array[i - 1][0]
                elif j == a:
                    array[i][a] += array[i-1][a-1]
                    break
                else:
                    new = max(array[i-1][j-1], array[i-1][j])
                    array[i][j] += new
                a += 1

final = []
for i in range(n):
    final.append(array[n-1][i])

maximum = max(final)

print(maximum)