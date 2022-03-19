import sys

def counting(ar, word): # word 안에 있는 알파벳에 숫자 지정 후 있는지 확인....?
    for w in word:
        i = ord(w) - ord('A')
        ar[i] += 1

def solution(n, words):
    answer = 0
    diff = 0    # 두 단어간 알파벳 차이
    freq_firstword = [0] * 26
    length = len(words[0])  #첫번째 단어 길이

    counting(freq_firstword, words[0])

    for i in range(1, n):
        diff = 0
        freq_other = [0]*26
        counting(freq_other, words[i])

        for freq1, freq2 in zip(freq_other, freq_firstword):
            diff += abs(freq1 - freq2)

        if (diff == 0 or diff == 1 or (diff == 2 and len(words[i]) == length)):
            answer += 1

    return answer

if __name__ == "__main__":
    input = sys.stdin.readline
    n = int(input())
    words = [input().rstrip() for _ in range(n)]
    answer = solution(n, words)
    print(answer)
