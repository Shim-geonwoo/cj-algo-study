# 전략: 큐. 맨 앞 숫자를 꺼내 1~5를 차례로 빼고 맨 뒤에 넣기를 반복하다가,
#       0 이하가 되면 0을 넣고 멈춘다. 앞에서 꺼내는 일이 반복되므로 리스트 대신 deque를 쓴다.
# 시간복잡도: O(K)  — K는 반복 횟수로, 입력 숫자 크기에 비례 (한 번 꺼내고 넣기는 O(1))

from collections import deque
T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    

    tc = int(input())
    q = deque(map(int, input().split()))

    minus = 1
    while True:
        num = q.popleft() - minus
        if num <= 0:
            q.append(0)
            break
        q.append(num)
        minus += 1
        if minus > 5:
            minus = 1
    print("#" + str(tc), *q)
