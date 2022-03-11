n = int(input())

score_list = []
same_lang = []

for i in range(n):
    score_list.append(input().split())

score_list.sort(key=lambda x:x[1], reverse=True)

for i in range(n):
    count = 0
    count2 = 0
    min_index = i
    min_index_2 = i
    for j in range(i+1, n):
        if score_list[min_index][1] == score_list[j][1]:
            count += 1
    for k in range(min_index+1, min_index+count):
        for l in range(k, min_index, -1):
            if score_list[l][2] < score_list[l-1][2]:
                score_list[l], score_list[l-1] = score_list[l-1], score_list[l]
            else:
                break

print(score_list)