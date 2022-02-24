n = int(input())

d = [0] * 2000

d[1] = 1
d[2] = 3

for i in range(3, n+1):
    d[i] = 2 * d[i-2] + d[i-1]  # a(n) = 2(a(n-2)) + a(n-1)

print(d[n] % 796796)