def solution(N, stages):
    answer = []
    fail = {}
    num = len(stages)

    for i in range(1, N + 1):
        cnt = stages.count(i)
        fail[i] = cnt / num
        num -= cnt
        if (num == 0):
            fail[i] == 0

    sort_dict = dict(sorted(fail.items()))

    for i in range(1, N+1):
        answer.append(sort_dict[i].items())

    answer.sort(reverse=True)
    return answer

print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))