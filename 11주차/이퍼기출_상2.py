import sys
# 파이썬의 기본 재귀 호출 제한은 1000으로, 매우 작은 편입니다. 따라서 아래 코드를 이용해 재귀 깊이를 설정해주어야 합니다.
sys.setrecursionlimit(10**8)

row = [[0]*10 for _ in range(9)]    # rows[i][num] = i행에 num이 존재하는지 저장하는 리스트
col = [[0]*10 for _ in range(9)]    # cols[j][num] = j열에 num이 존재하는지 저장하는 리스트
area = [[0]*10 for _ in range(9)]   # areas[a][num] = a번 3x3 영역에 num이 존재하는지 저장하는 리스트
blank_cord = []     # 비어있는 칸의 좌표를 저장할 리스트
# 좌표를 영역번호로 바꾸어주는 함수
def find_area(x, y):
    return 3*(x//3)+(y//3)

def backtraking(k, N, answer):
    if k == N: return True     # 마지막 빈칸까지 채웠으면, 완성되었음(true)을 리턴합니다.
    i, j = blank_cord[k]
    a = find_area(i, j)

    # 1부터 9까지 차례대로 검사한다.
    for x in range(1, 10):
        # 가로줄, 세로줄, 영역을 모두 체크해 가능한 경우 진행한다.
        if row[i][x] == 0 and col[j][x] == 0 and area[a][x] == 0:
            # (x,y)에 num이 들어갈 수 있으므로, 우선 집어넣는다.
            row[i][x] = 1
            col[j][x] = 1
            area[a][x] = 1

            answer[i][j] = x # 현재까지의 상태를 answer에 저장
            if backtraking(k+1, N, answer):
                return True     # 만약 마지막 빈칸까지 채워졌다면, 여기서 true를 리턴하여 탐색 종료.

            # 현재 상태에서 해당칸에 num으로 진행하다가 막혔기 때문에, 체크배열을 원래대로 돌려놓고 다음 경우의 수 마저 탐색.
            row[i][x] = 0
            col[j][x] = 0
            area[a][x] = 0

    return False

def solution(sudoku):
    answer = [[0]*9 for _ in range(9)]      # 정답 = 현재의 상태를 저장하는 리스트
    for i in range(9):
        for j in range(9):
            if sudoku[i][j] == 0: blank_cord.append((i, j))   # 빈칸의 좌표를 벡터에 추가
            else:
                # 각 행과 열, 영역에 이미 부여된 숫자임을 체크 배열에 표기, 정답 배열에 숫자 복사
                row[i][sudoku[i][j]] = 1
                col[j][sudoku[i][j]] = 1
                area[find_area(i, j)][sudoku[i][j]] = 1
                answer[i][j] = sudoku[i][j]

    backtraking(0, len(blank_cord), answer)
    return answer

if __name__ == "__main__":
    input = sys.stdin.readline
    sudoku = [list(map(int, input().split())) for _ in range(9)]
    output = solution(sudoku)
    for line in output:
        for num in line:
            print(num, end=' ')
        print()
