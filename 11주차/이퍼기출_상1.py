import sys
sys.setrecursionlimit(10 ** 8)  # 재귀 사용시 재귀 깊이 제한을 1000이상으로 늘리기 위함

board = []
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

def dfs(n, m, row, col):    # 치즈 외부와 내부를 구분하는 함수
    if row < 0 or row >= n or col < 0 or col >= m or board[row][col] != 0:  # 범위 밖이거나 치즈가 있거나 외부 공기일때 dfs 중지
        return
    board[row][col] = -1    # 외부 공기로 표시
    for i in range(4):
        dfs(n, m, row+dr[i], col+dc[i]) # 재귀함수

def canMelt(row, col):  # 한 픽셀이 녹을 수 있는 치즈인지 구별하는 함수
    cnt = 0
    for i in range(4):  # 한 픽셀 기준으로 네 방향으로 움직이며 접촉한 외부 공간이 2개 이상인지 판별
        nr = row + dr[i]
        nc = col + dc[i]
        if board[nr][nc] == -1: # 외부공간이라면
            cnt += 1
    return cnt >= 2 # 접촉한 변이 두개 이상인 경우만 리턴

def findCheese(n, m):   # 녹을 치즈 모두 찾는 함수
    cheese = list()
    for i in range(n):
        for j in range(m):
            if board[i][j] == 1 and canMelt(i, j):  #녹지 않았으면서 녹을 수 있는 치즈라면
                cheese.append([i, j])
    return cheese   # 녹일 예정인 치즈 모두 반환

def solution(n, m, input_board):
    for i in range(n):
        board.append(input_board[i][:])
    answer = 0
    dfs(n, m, 0, 0)
    while True:
        cheese = findCheese(n, m)
        if not cheese:  # 더 녹일 치즈가 없다면 루프 끝내기
            break
        for a in cheese:
            row, col = a
            board[row][col] = 0 # 녹였으므로 0으로 변환
            dfs(n, m, row, col)
        answer += 1 # 한번 녹일때마다 한시간씩 추가
    return answer

if __name__ == "__main__":
    input = sys.stdin.readline
    n, m = map(int, input().split())
    input_board = [list(map(int, input().split())) for _ in range(n)]
    answer = solution(n, m, input_board)
    print(answer)
