package org.example.solution.implementation.programmers;

import java.util.*;

// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/76502
public class Solution76502 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "}}}";
        System.out.println(solution.solution(s));
    }

    static class Solution {
        public int solution(String s) {
            int answer = 0;

            char[] charArray = s.toCharArray();
            List<Character> list = new ArrayList<>();
            for(Character c : charArray) {
                list.add(c);
            }

            Deque<Character> deque = new ArrayDeque<>(list);
            for(int i = 0; i < s.length(); ++i) {
                if(i != 0) {
                    Character c = deque.removeFirst();
                    deque.addLast(c);
                }

                if(isCorrectBracket(deque.toArray(new Character[0]))) {
                    answer++;
                }
            }

            return answer;
        }

        public boolean isCorrectBracket(Character[] array) {
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < array.length; ++i) {
                Character c = array[i];
                if(stack.isEmpty()) {
                    stack.add(c);
                    continue;
                }

                Character peek = stack.peek();
                if(peek == '(' && c == ')') {
                    stack.pop();
                } else if(peek == '{' && c == '}') {
                    stack.pop();
                } else if(peek == '[' && c == ']') {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }

            return stack.isEmpty();
        }
    }
}

// 풀이방법: 문제 그대로 구현, deque를 이용하여 왼쪽으로 shift를 처리하고, stack을 통해 괄호 옳은지 판단