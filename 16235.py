"""
* 문제에서 제시된 N은 최대 10이므로, 최대 10 X 10 크기의 맵이 될 것이다.
* 문제에서 요구하는 내용을 그대로 구현해야 하는 [시뮬레이션 유형]의 문제다.
* 인접한 위치는 8개로 간주한다.
    1. (r-1, c-1)
    2. (r-1, c)
    3. (r-1, c+1)
    4. (r, c-1)
    5. (r, c+1)
    6. (r+1, c-1)
    7. (r+1, c)
    8. (r+1, c+1) 
"""

n, m, k = map(int, input().split())

# 현재 양분 정보로, 처음에는 5씩 들어있다.
energy = [[5] * n for _ in range(n)]
# 겨울에 각 위치에 추가할 양분 정보 입력
arr = []
for _ in range(n):
    line = list(map(int, input().split()))
    arr.append(line)
# N X N 크기의 격자에 각각 나무(tree)를 리스트로 표현
trees = [[[] for j in range(n)] for i in range(n)]
for _ in range(m):
    # 각 나무의 (x, y) 좌표와 나이(age) 정보 입력
    x, y, age = map(int, input().split())
    # 배열의 인덱스는 0부터 출발하므로 1씩 빼서 넣기
    trees[x - 1][y - 1].append(age)

# 인접한 8가지 방향
dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

# N X N 크기의 격자에 각각 죽은 나무(tree)를 리스트로 표현
died = [[[] for j in range(n)] for i in range(n)]


def spring(): # 봄일 때
    for i in range(n):
        for j in range(n):
            trees[i][j].sort()  # 오름차순 정렬
            # 해당 위치의 나무들의 나이를 하나씩 확인
            for k in range(len(trees[i][j])):
                # 양분이 충분하다면 나이만큼 양분 먹기
                if trees[i][j][k] <= energy[i][j]:
                    energy[i][j] -= trees[i][j][k]
                    trees[i][j][k] += 1
                # 양분이 부족하다면 나이 많은 나무들은 죽고, 반복문 탈출
                else:
                    for age in trees[i][j][k:]:
                        died[i][j].append(age)
                    trees[i][j] = trees[i][j][:k]
                    break


def summer():
    for i in range(n):
        for j in range(n):
            for age in died[i][j]:
                energy[i][j] += (age // 2)
            died[i][j] = []


def autumn():
    for i in range(n):
        for j in range(n):
            for age in trees[i][j]:
                # 나이가 5의 배수인 경우
                if age % 5 == 0:
                    for k in range(8):
                        nx = i + dx[k]
                        ny = j + dy[k]
                        if nx < 0 or nx >= n or ny < 0 or ny >= n:
                            continue
                        trees[nx][ny].append(1)


def winter():
    for i in range(n):
        for j in range(n):
            energy[i][j] += arr[i][j]


for _ in range(k):
    spring()
    summer()
    autumn()
    winter()

result = 0
for i in range(n):
    for j in range(n):
        result += len(trees[i][j])
print(result)
