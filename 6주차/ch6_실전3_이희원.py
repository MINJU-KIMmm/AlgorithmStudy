import operator

n = int(input())

diction = {}

for i in range(n):
    name, score = input().split()
    diction[name] = int(score)

sort_dict = dict(sorted(diction.items()))

for key in sort_dict.keys():
    print(key, end = ' ')