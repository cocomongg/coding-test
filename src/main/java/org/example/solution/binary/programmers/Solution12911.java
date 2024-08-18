package org.example.solution.binary.programmers;

import java.util.List;

// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12911
public class Solution12911 {
    public static void main(String[] args) {
        List<Integer> nList = List.of(78, 15);

        nList.forEach(n -> System.out.println(solution1(n)));
    }

    public static int solution1(int n) {
        int answer = 0;
        String nBinaryString = Integer.toBinaryString(n);
        int conditionLength = nBinaryString.replace("0", "").length();

        n += 1;
        while(true) {
            int length = Integer.toBinaryString(n)
                    .replace("0", "")
                    .length();

            if(conditionLength == length) {
                break;
            }

            n++;
        }

        answer = n;
        return answer;
    }

    public static int solution2(int n) {
        int answer = 0;
        int conditionBitCount = Integer.bitCount(n);

        n += 1;
        while(true) {
            int currentBitCount = Integer.bitCount(n);

            if(conditionBitCount == currentBitCount) {
                break;
            }

            n++;
        }

        answer = n;
        return answer;
    }
}

// 문제풀이: 이진수로 변환 후 반복문을 돌면서 이진수 문자열 길이를 비교
// 참고: String의 replace와 replaceAll의 수행하는 기능은 같지만, replaceAll은 정규표현식을 통해 복잡한 문자열도 가능
//      성능은 replace가 더 좋다.
//      Integer의 bitCount를 통해 숫자의 1bit개수를 구할 수 있다.