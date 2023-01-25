from collections import deque

n, k = map(int, input().split())
visited = [0] * 100001

queue = deque()
queue.append(n)
visited[n] = 1

while queue:
    current = queue.popleft()
    if current - 1 >= 0:
        if visited[current - 1] == 0:
            visited[current - 1] = visited[current] + 1
            queue.append(current - 1)
    if current + 1 <= 100000:
        if visited[current + 1] == 0:
            visited[current + 1] = visited[current] + 1
            queue.append(current + 1)
    if current * 2 <= 100000:
        if visited[current * 2] == 0:
            visited[current * 2] = visited[current] + 1
            queue.append(current * 2)

print(visited[k] - 1)
