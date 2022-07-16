import heapq
# 일반적인 큐(queue) 대신에 힙(heap)을 쓰는 이유는
# (검은 방을 없애는 횟수, x, y) 형태로 원소를 입력 받으면
# 검은 방을 없애는 횟수가 적은 순서대로 꺼내지기 때문에
# 목표 지점에 처음 도달한 경우, 가장 검은 방은 적게 없앤 결과가 나옴.

n = int(input())
# 2차원 맵 생성
graph = [[0] * n for _ in range(n)]
# 2차원 맵 입력받기
for i in range(n):
    row = input()
    for j in range(n):
        graph[i][j] = int(row[j])

# 상, 하, 좌, 우 방향 정보
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 방문 처리 배열
visited = [[-1] * n for _ in range(n)]

# BFS 수행
queue = []
# (검은 방을 없앤 횟수, x, y)를 큐에 삽입
heapq.heappush(queue, (0, 0, 0))
visited[0][0] = 0 # 검은 방을 없앤 횟수
while queue: # 큐가 빌 때까지
    count, x, y = heapq.heappop(queue)
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        # 맵을 벗어나는 경우 무시
        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue
        # 방문하지 않은 위치라면
        if visited[nx][ny] == -1:
            # 검은 방인 경우 카운트를 증가해서 삽입
            if graph[nx][ny] == 0:
                visited[nx][ny] = count + 1
                queue.append((count + 1, nx, ny))
            # 흰 방인 경우 카운트를 그대로 삽입
            else:
                visited[nx][ny] = count
                queue.append((count, nx, ny))

print(visited[n - 1][n - 1])
"""
print('결과')
for i in range(n):
    for j in range(n):
        print(visited[i][j], end='')
    print()
"""
