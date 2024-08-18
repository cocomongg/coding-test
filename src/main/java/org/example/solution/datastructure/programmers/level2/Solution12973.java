package org.example.solution.datastructure.programmers.level2;

import java.util.List;
import java.util.Stack;

// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12973
public class Solution12973 {

    public static void main(String[] args) {
        List<String> s = List.of("baabaa", "cdcd");
        s.forEach(str -> System.out.println(solution(str)));
    }

    public static int solution(String s)
    {
        int answer = -1;

        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(charArray[0]);
        for(int i = 1; i < charArray.length; ++i) {
            if(stack.isEmpty()) {
                stack.push(charArray[i]);
            } else {
                if(stack.peek() == charArray[i]) {
                    stack.pop();
                } else {
                    stack.push(charArray[i]);
                }
            }
        }

        answer = stack.isEmpty() ? 1 : 0;
        return answer;
    }
}

// 풀이방법: stack 이용
