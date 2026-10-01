# 전략: 완전탐색. 자르는 단위를 1~len/2까지 모두 시도한다. 각 단위마다 문자열을 조각으로 나누고
#       연속된 같은 조각을 개수+조각으로 묶어 길이를 구한 뒤 최솟값을 고른다.
# 시간복잡도: O(N²)  — 단위 N/2가지 × 매번 문자열 전체 N

def solution(s):
    answer = len(s)

    for size in range(1, len(s) // 2 + 1):

        # 1단계: s를 size 글자씩 잘라서 조각 리스트 만들기
        pieces = []
        piece = ""
        for i in range(len(s)):
            piece += s[i]
            if len(piece) == size:
                pieces.append(piece)
                piece = ""
        if piece != "":
            pieces.append(piece)

        # 2단계: 같은 조각이 연속되면 개수로 묶기
        result = ""
        prev = pieces[0]
        count = 1
        for j in range(1, len(pieces)):
            if pieces[j] == prev:
                count += 1
            else:
                if count > 1:
                    result += str(count)
                result += prev
                prev = pieces[j]
                count = 1
        if count > 1:
            result += str(count)
        result += prev

        # 3단계: 가장 짧은 길이 기억하기
        if len(result) < answer:
            answer = len(result)

    return answer