def solution(s):
    s_length = len(s)
    answer = s_length
    for i in range(s_length // 2):
        unit = ""
        front = s[0:i + 1]
        count = 1
        for j in range(i + 1, s_length, i + 1):
            if front == s[j:j + (i + 1)]:
                count += 1
            else:
                if count > 1:
                    unit += str(count) + front
                else:
                    unit += front
                front = s[j:j + (i + 1)]
                count = 1
        if count > 1:
            unit += str(count) + front
        else:
            unit += front
        answer = min(answer, len(unit))

    return answer