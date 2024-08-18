package org.example.solution.string.programmers;

import java.util.List;

// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12951
public class Solution12951 {
    public static void main(String[] args) {
        List<String> sList = List.of("3people unFollowed me", "for the last week");
        sList.forEach(s -> System.out.println(solution(s)));
    }

    public static String solution(String s) {
        String answer = "";
        char[] charArray = s.toCharArray();
        boolean isBeforeSpaceChar = false;

        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(charArray[0]).toUpperCase());
        for(int i = 1; i < charArray.length; ++i) {
            char c = charArray[i];

            if(c == ' ') {
                sb.append(c);
                isBeforeSpaceChar = true;
                continue;
            }

            String str = String.valueOf(c);
            if(isBeforeSpaceChar) {
                sb.append(str.toUpperCase());
                isBeforeSpaceChar = false;
            } else {
                sb.append(str.toLowerCase());
            }
        }

        answer = sb.toString();
        return answer;
    }
}

// 문제풀이: 문자열의 문자를 순회하면서 조건에 맞게 가공
// 참고: 문자가 숫자인지 확인하는 함수: Character.isDigit()
