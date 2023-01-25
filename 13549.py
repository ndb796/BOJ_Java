from collections import deque

n, k = map(int, input().split())
visited = [0] * 100001

queue = deque()
queue.append(n)
visited[n] = 1

while queue:
    current = queue.popleft()
    # 2의 제곱으로 10만 이상이 되기 위해 최대 16~17회이므로 가능한 방법
    temp = current * 2
    while temp <= 100000:
        if visited[temp] == 0:
            visited[temp] = visited[current]
            queue.append(temp)
        if temp == 0: break
        temp *= 2
    if current - 1 >= 0:
        if visited[current - 1] == 0:
            visited[current - 1] = visited[current] + 1
            queue.append(current - 1)
    if current + 1 <= 100000:
        if visited[current + 1] == 0:
            visited[current + 1] = visited[current] + 1
            queue.append(current + 1)


print(visited[k] - 1)

"""
import heapq

n, k = map(int, input().split())
distance = [int(1e9)] * 100001

q = []
heapq.heappush(q, (0, n))
distance[n] = 0

while q:
    dist, current = heapq.heappop(q)
    if current - 1 >= 0:
        if distance[current - 1] > dist + 1:
            distance[current - 1] = dist + 1
            heapq.heappush(q, (dist + 1, current - 1))
    if current + 1 <= 100000:
        if distance[current + 1] > dist + 1:
            distance[current + 1] = dist + 1
            heapq.heappush(q, (dist + 1, current + 1))
    if current * 2 <= 100000:
        if distance[current * 2] > dist:
            distance[current * 2] = dist
            heapq.heappush(q, (dist, current * 2))

print(distance[k])
"""
