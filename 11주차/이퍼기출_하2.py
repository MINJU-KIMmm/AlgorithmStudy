def solution(time, n):
	answer =0
	time.sort()
	for i in range(n):
		answer += time[i]*(n-i)
	return answer



if __name__=="__main__" :
	n = int(input())
	time = list(map(int, input().split()))
	answer=solution(time,n)
	print(answer)
