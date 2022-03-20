import sys
import queue

def solution(m, n, picture):
    num_of_area = 0 # 영역의 개수
    max_size_of_one_area = 0    # 가장 큰 영역의 픽셀 넓이

    dx = [0, 0, -1, +1]
    dy = [-1, +1, 0, 0]

    que = queue.Queue() # 좌표를 넣은 큐 정의

    for i in range(m):
        for j in range(n):  # 모든 픽셀 확인
            if picture[i][j] == 0:  # 이미 방문한 픽셀
                continue
            else:
                num_of_area += 1    # 영역의 개수 하나 추가
                cnt = 0     # 한 영역의 픽셀 세는 단위
                que.put((i, j))     # 큐에 좌표 삽입
                color = picture[i][j]   # 색 종류
                picture[i][j] = 0   # 색을 알아낸 뒤 방문했다는 표시

                while que.qsize() > 0:  # 큐에 좌표가 있다면
                    cnt += 1    # 그 픽셀 개수 세기
                    x, y = que.get()    # 제일 앞에 있는 큐의 좌표를 pop
                    for k in range(4):  # 왼쪽 오른쪽 아래 위 네 방향이므로 for문을 각 방향으로 4번 돌림
                        if 0 <= x+dx[k] < m and 0 <= y+dy[j] < n and picture[x+dx[k]][y+dy[k]]==color:  # 이동한 후 x, y좌표가 범위 내에 있는지, 그리고 움직인 픽셀의 값이 동일한 색상이 맞는지 확인
                            que.put((x+dx[k], y+dy[k])) # 동일 영역의 픽셀을 찾았으므로 que에 삽입
                            picture[x+dx[k]][y+dy[k]] = 0   # 방문 기록
                max_size_of_one_area = max(max_size_of_one_area, cnt)   # 최댓값 갱신
    return [num_of_area, max_size_of_one_area]