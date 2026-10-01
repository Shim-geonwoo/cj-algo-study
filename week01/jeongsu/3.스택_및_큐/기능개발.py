# 전략: 구현. 기능마다 남은 날 = (100-진도)/속도를 올림해 구한 뒤,
#       앞 기능의 배포일보다 일찍 끝난 기능은 같은 묶음으로 세고 늦으면 새 묶음을 시작한다.
# 시간복잡도: O(N)

def solution(progresses, speeds):
    answer = []

    # 1단계: 기능마다 며칠 걸리는지 구하기
    days = []
    for i in range(len(progresses)):
        remain = 100 - progresses[i]
        day = remain // speeds[i]
        if remain % speeds[i] != 0:     # 나누어떨어지지 않으면 하루 더
            day += 1
        days.append(day)

    # 2단계: 앞 기능이 배포될 때 같이 나갈 수 있는 것끼리 묶기
    release = days[0]                   # 지금 묶음이 배포되는 날
    count = 0
    for d in days:
        if d <= release:                # 앞 기능 배포일까지 이미 끝남
            count += 1
        else:                           # 더 늦게 끝남 → 새 묶음
            answer.append(count)
            release = d
            count = 1
    answer.append(count)                # 마지막 묶음

    return answer