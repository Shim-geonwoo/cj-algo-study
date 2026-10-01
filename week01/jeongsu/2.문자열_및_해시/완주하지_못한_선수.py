# 전략: 해시(딕셔너리). 참가자 이름마다 +1, 완주자 이름마다 -1 해서
#       값이 0이 아닌 이름(동명이인 포함)을 찾는다.
# 시간복잡도: O(N)  — 딕셔너리 넣기,찾기가 O(1)


def solution(participant, completion):
    answer = ''
    cnt = {}
    
    for name in participant:
        if name in cnt:
            cnt[name] +=1
        else:
            cnt[name] =1
            
    for name in completion:
        cnt[name]-=1
        
    for name in cnt:
        if cnt[name] != 0:
            return name
    return answer