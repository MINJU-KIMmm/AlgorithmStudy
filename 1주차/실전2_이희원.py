n, m, k = map(int, input().split())     # 첫째 문장
list = list(map(int, input().split()))  # 둘째 문장
result = 0

# print(n, m, k, list)

list.sort(reverse=True)
print(list)
first = list[0]
second = list[1]
count = 0

while count < m:
    for i in range(k):
        if (count >= m):
            break
        result += first
        count += 1
    if (count >= m):
        break
    result += second
    count += 1

print(result)

# better way
# count = int(m/(k+1)) * k    # 반복되는 개수 구하기
# count += m * (k+1)
# result += (count) * first
# result += (m-count) * second