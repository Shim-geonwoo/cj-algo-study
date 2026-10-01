# 전략: 완전탐색. 파리채(M×M)를 놓을 수 있는 모든 왼쪽 위 칸(N-M+1)곳에 놓아보고
#       각 자리에서 M×M칸의 합을 구해 최댓값을 갱신한다.
# 시간복잡도: O(N² × M²)


T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    fly =[ ]

    # 입력
    for i in range(n):
        number = list(map(int,input().split()))
        fly.append(number)
    fly.append(number)

    #알고리즘
    max = 0
    for i in range((n-m+1)):
        for j in range((n-m+1)):
            sum = 0
            for a in range(0,m):
                for b in range(0,m):
                    sum+=fly[i+a][j+b]
                    if sum > max:
                        max = sum
    print("#"+str(test_case), max)