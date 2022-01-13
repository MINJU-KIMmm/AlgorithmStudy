n, m = map(int, input().split())

least = []

for i in range(n):
    for i in range(m):
        data = list(map(int, input().split()))
        data.sort()
        least.append(data[0])
    least.sort()
    print(least[n-1])
    break;