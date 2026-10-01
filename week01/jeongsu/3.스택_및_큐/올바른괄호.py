# 전략: 스택. '('는 쌓고 ')'를 만나면 하나 꺼내 짝을 지운다.
#       ')'인데 스택이 비었거나, 끝났는데 스택이 남았으면 올바르지 않다.
# 시간복잡도: O(N)

def solution(s):
    answer = True
    
    stack = []
    
    for i in s:
        if i == "(":
            stack.append(i)
        else:
            if len(stack) == 0:
                return False
            stack.pop()
            
    return len(stack) == 0

    return True