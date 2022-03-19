def solution(n):
    answer = 0
    for i in range(1, n+1):
        result = i
        result += sum(map(int,str(i)))
        if result == n:
            answer = i
            break
    return answer

if __name__ == "__main__":
    n = int(input())
    answer = solution(n);
    print(answer)
