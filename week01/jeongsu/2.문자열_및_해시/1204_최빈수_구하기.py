# 전략: 카운팅. 점수가 0~100이므로 크기 101 리스트에 점수를 칸 번호로 써서 센다.
#       0점부터 올라가며 >=로 비교해 빈도가 같으면 더 큰 점수가 남게 한다.
# 시간복잡도: O(N + 101) = O(N)  — 학생 N명 세기 + 점수 101칸 훑기

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
   
    n = int(input())                       # 테스트 케이스 번호 줄
    scores = list(map(int, input().split())) # 점수 1000개

    cnt = [0] * 101                        # 0점~100점 각각 몇 명인지
    for s in scores:
        cnt[s] += 1

    result = 0
    for score in range(101):
        if cnt[score] >= cnt[result]:      # 같으면 큰 점수로 갱신
            result = score

    print("#" + str(n), result)