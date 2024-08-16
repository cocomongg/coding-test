package org.example.solution.datastructure.programmers.level2;


import java.util.*;
import java.util.stream.Collectors;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class Solution12909 {
    public static void main(String[] args) {
        List<String> testCases = List.of("()()", "(())()", ")()(", "(()(");
        testCases.forEach(s -> {
            System.out.println("result: " + solution(s));
        });
    }

    public static boolean solution(String s) {
        boolean answer = true;

        char[] charArray = s.toCharArray();
        if(charArray[0] == ')') {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < charArray.length; ++i) {
            char current = charArray[i];

            if(stack.isEmpty()) {
                stack.add(current);
                continue;
            }

            char last = stack.pop();
            if(last  != '(' || current != ')') {
                stack.add(last);
                stack.add(current);
            }
        }

        answer = stack.isEmpty();
        return answer;
    }
}

// 문제풀이: stack을 이용하여 stack의 head와 현재 문자를 비교하고, '()'이 케이스라면 stack에 넣지 않음.
// 참고: 맨처음에 String의 split을 사용했는데 효율성 검증에서 시간초과 발생. split대신 char배열로 접근 후 통과