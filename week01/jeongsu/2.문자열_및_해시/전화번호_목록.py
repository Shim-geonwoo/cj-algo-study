# 전략: 해시(set). 모든 번호를 set에 넣고, 각 번호의 앞 1~(길이-1)글자가 set에 있는지 확인한다.
#       하나라도 있으면 다른 번호의 접두어이므로 False.
# 시간복잡도: O(N × L²)  — L은 번호 길이(최대 20)라 사실상 O(N)


def solution(phone_book):
    answer = True
    numbers = set(phone_book)
    
    for phone in phone_book:
        for i in range(1,len(phone)):
            if phone[:i] in numbers:
                return False
    return True
    return answer