from collections import deque

n, k = map(int, input().split())
visited = [0] * 100001
prev = [-1] * 100001  # 자신의 이전 노드

queue = deque()
queue.append(n)
visited[n] = 1

while queue:
    current = queue.popleft()
    if current - 1 >= 0:
        if visited[current - 1] == 0:
            visited[current - 1] = visited[current] + 1
            prev[current - 1] = current  # 경로 추적을 위해
            queue.append(current - 1)
    if current + 1 <= 100000:
        if visited[current + 1] == 0:
            visited[current + 1] = visited[current] + 1
            prev[current + 1] = current  # 경로 추적을 위해
            queue.append(current + 1)
    if current * 2 <= 100000:
        if visited[current * 2] == 0:
            visited[current * 2] = visited[current] + 1
            prev[current * 2] = current  # 경로 추적을 위해
            queue.append(current * 2)

# 경로 추적 결과 출력
result = [k]
cur = k
while prev[cur] != -1:
    cur = prev[cur]
    result.append(cur)

print(visited[k] - 1)  # 최단 거리 출력
for x in reversed(result):  # 경로 출력
    print(x, end=" ")
