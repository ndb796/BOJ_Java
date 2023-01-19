"""
[문제 해결 아이디어]
* 전체 나라의 개수가 6개 밖에 없으므로,
가능한 두 나라의 쌍 (X, Y)에 대하여
승/무/패 여부를 고려한다.

즉, 하나의 쌍 (X, Y)가 주어졌을 때, 가능한 경우의 수는 3개다. (승/무/패)
이때, 총 6C2 = 15개의 쌍이 있으므로, 모든 조합에 대하여 고려하면
3^15가지 경우의 수가 있는 것이다.

3^3을 27 => 30이라고 보자.
결과적으로 30 * 30 * 30 * 30 * 30의 경우의 수
=> 대략적으로약 2천만 번 정도의 연산이 필요

* 구현을 어떻게 해야 하는가?
 0      1       2       3        4
(A, B), (A, C), (A, D), (A, E), (A, F)
  5      6        7      8
(B, C), (B, D), (B, E), (B, F)
  9       10    11
(C, D), (C, E), (C, F)
  12    13
(D, E), (D, F)
  14
(E, F)
15개이므로, 차례대로
(왼쪽이 승이면 1, 무: 0, 왼쪽이 패면 -1)
arr[15] = [1, -1, 0, ...] 이렇게 표현하면?

A 기준: arr[0], arr[1], arr[2], arr[3], arr[4] 보기
B 기준: -arr[0], arr[5], arr[6], arr[7], arr[8] 보기
C 기준: -arr[1], -arr[5], arr[9], arr[10], arr[11] 보기
D 기준: -arr[2], -arr[6], -arr[9], arr[12], arr[13] 보기
E 기준: -arr[3], -arr[7], -arr[10], -arr[12], arr[14]

index_a = [0, 1, 2, 3, 4]
index_b = [-0, 5, 6, 7, 8]
index_c = [-1, -5, 9, 10, 11]
index_d = [-2, -6, -9, 12, 13]
index_e = [-3, -7, -10, -12, 14]
"""

import sys

sys.setrecursionlimit(int(1e8))

index_a = [0, 1, 2, 3, 4]
index_b = [-0, 5, 6, 7, 8]
index_c = [-1, -5, 9, 10, 11]
index_d = [-2, -6, -9, 12, 13]
index_e = [-3, -7, -10, -12, 14]
index_f = [-4, -8, -11, -13, -14]


def possible(country, indices):
    win, draw, lose = country
    # 현재 조합에 대하여 확인
    for i in indices:
        if i >= 0:
            # 승리했다면
            if result[i] == 1:
                win -= 1
            # 무승부라면
            elif result[i] == 0:
                draw -= 1
            # 패배했다면
            else:
                lose -= 1
        if i < 0:
            # 승리했다면
            if result[i] == -1:
                win -= 1
            # 무승부라면
            elif result[i] == 0:
                draw -= 1
            # 패배했다면
            else:
                lose -= 1
    return (win == 0) and (draw == 0) and (lose == 0)


def dfs(depth, start):
    global check
    # 현재 조합에 대하여 결과 계산
    if depth == 15:
        # print(result)
        if not possible(a, index_a): return
        if not possible(b, index_b): return
        if not possible(c, index_c): return
        if not possible(d, index_d): return
        if not possible(e, index_e): return
        if not possible(f, index_f): return
        # 가능한 경우이다.
        check = True
        return
    for i in range(start, 15):
        if visited[i]: continue
        # (승, 무, 패)에 대한 모든 경우의 수 계산
        for cur in [1, 0, -1]:
            visited[i] = True
            result.append(cur)
            dfs(depth + 1, i + 1)
            visited[i] = False
            result.pop()


for _ in range(4):
    data = list(map(int, input().split()))
    a = data[0:3]
    b = data[3:6]
    c = data[6:9]
    d = data[9:12]
    e = data[12:15]
    f = data[15:18]

    check = False
    visited = [False] * 15
    result = []
    dfs(0, 0)
    if check: print(1, end=" ")
    else: print(0, end=" ")
