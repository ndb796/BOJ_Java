"""
* "모든 조합"을 구하는 문제입니다.
  * Why? 재료 (A, B, C)를 사용한 것과 재료 (A, C, B)를 사용한 것이 같은 결과를 가진다.
* 이때, 1개만 써도 되고, 2개만 써도 되고, ... N개를 써도 되니까
  * "모든 개수"에 대하여 "모든 조합"을 구하는 문제입니다.

[Example]
* A, B, C, D라는 재료가 있습니다.
* 길이 #1
  - A만 사용할 때
  - B만 사용할 때
  - C만 사용할 때
  - D만 사용할 때
* 길이 #2
  - (A, B)
  - (A, C)
  - (A, D)
  - (B, C)
  - (B, D)
  - (C, D)
* 길이 #3
  - (A, B, C)
  - (A, B, D)
  - (A, C, D)
  - (B, C, D)
* 길이 #4
  - (A, B, C, D)
"""

import sys
sys.setrecursionlimit(int(1e6))

n = int(input())
arr = []
for i in range(n):
    x, y = map(int, input().split())
    arr.append((x, y))

visited = [False] * n
result = []
answer = int(1e9)

def dfs(depth, start):
    global answer
    # 현재 조합에 대하여 결과 계산
    if depth >= 1:
        totalX = 1;
        totalY = 0;
        for i in result:
            x, y = arr[i]
            totalX *= x;
            totalY += y;
        answer = min(answer, abs(totalX - totalY))
    for i in range(start, n):
        if visited[i]: continue
        visited[i] = True
        result.append(i)
        dfs(depth + 1, i + 1)
        visited[i] = False
        result.pop()

dfs(0, 0)
print(answer)
