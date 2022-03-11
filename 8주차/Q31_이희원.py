t = int(input())

n, m = map(int, input().split())

def search(a, b, array_in_function):
    for i in range(a):
        for j in range(1, b):
            if i == 0:
                new = max(array_in_function[i][j - 1], array_in_function[i + 1][j - 1])
                array_in_function[i][j] += new
            elif i == a:
                new = max(array_in_function[i-1][j - 1], array_in_function[i][j - 1])
                array_in_function[i][j] += new
            else:
                new = max(array_in_function[i - 1][j - 1], array_in_function[i][j - 1], array_in_function[i + 1][j - 1])
                array_in_function[i][j] += new


arr = list(map(int, input().split()))

array = [[0]*m for _ in range(n)]
k=0

for i in range(n):
    for j in range(m):
        array[i][j] = arr[k]
        k += 1

print(array)

search(n, m, array)

final = []
for i in range(n):
    final.append(array[i][m])

maximum = max(final)

print(maximum)