def dfs(v, visited, x, y, sum, cnt):
    dx = [0, 0, -1, +1]
    dy = [-1, +1, 0, 0]     # 왼쪽 오른쪽 아래 위 방향 정의

    nx = 0
    ny = 0

    if (cnt == 5):  # 5번 움직여서 여섯자리수가 만들어졌고
        if (visited[sum] == False): # 새로운 여섯자리 수라면
            visited[sum] == True    # 방문했다고 표시
        return

    for i in range(4):  # 네 방향으로 이동
        nx = x + dx[i]
        ny = y + dy[i]

        if (nx >= 0 and ny >= 0 and nx < 5 and ny < 5): # 이동한 좌표가 범위 내에 있다면
            dfs(v, visited, nx, ny, sum * 10 + v[nx][ny], cnt + 1)  # 이동한 방향의 숫자를 추가하여 여섯자리 수를 만들어가는 과정을 재귀적으로 호출
    return

def solution(v):    # dfs는 단순히 여섯자리를 만드는 함수이므로 전체적인 함수 생성
    answer = 0
    visited = [0] * 1000000 # 문제 조건만큼 000000~999999만큼 빈 배열 선언

    for i in range(5):  # 숫자판의 모든 좌표에 접근하여 여섯자리 숫자를 만들어 간다
        for j in range(5):
            dfs(v, visited, i, j, v[i][j], 0)

    for i in range(1000000):    # 만들어진 모든 수의 배열 중
        if (visited[i]==1): # 방문된(즉, 중복되지 않는) 수에 한해
            answer += 1     # 개수를 센다

    return answer   # 총 개수 리턴

if __name__ == "__main__":  # 인터프리터에서 직접 실행된 경우에만 아래의 코드 실행
    answer = 0  # 개수 초기화
    board=[[0]*5 for _ in range(5)] # 빈 숫자판 생성

    for i in range(5):
        board[i] = list(map(int, input().split()))

    answer = solution(board)
    print(answer)
