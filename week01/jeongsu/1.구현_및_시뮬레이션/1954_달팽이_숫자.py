# 전략: 구현(시뮬레이션). 오른쪽,아래,왼쪽,위 방향을 dr/dc 배열로 두고 한 칸씩 숫자를 채운다.
#       다음 칸이 범위 밖이거나 이미 채워졌으면 d=(d+1)%4로 방향을 바꾼다.
# 시간복잡도: O(N²)  — 칸 N²개를 한 번씩 채움

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    r,c = 0, 0 # 행, 열
    d = 0 # 방향

    snail = [[0] * n for _ in range(n)]
    dr = [0,1,0,-1]
    dc = [1,0,-1,0]

    for i in range(1,(n*n+1)):
        snail[r][c] = i
        nr = dr[d] +r
        nc = dc[d] +c
        if nr <0 or nr>=n or nc <0 or nc>=n  or snail[nr][nc] != 0:
            d = (d+1)%4
            nr = dr[d] + r
            nc = dc[d] +c
        r, c = nr, nc
    print("#"+str(test_case))
    for k in range(n):
        print(*snail[k])
