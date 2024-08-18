package org.example.solution.implementation.programmers;

import java.util.Arrays;
import java.util.List;

public class Solution70129 {

    public static void main(String[] args) {
        List<String> strings = List.of("110010101001", "01110", "1111111");
        strings.forEach(s -> {
            int[] solution = solution(s);
            System.out.println(solution[0] + " " + solution[1]);
        });
    }

    public static int[] solution(String s) {
        int[] answer = {0, 0};

        while(!s.equals("1")) {
            s = converter(s, answer);
        }

        return answer;
    }

    public static String converter(String s, int[] answer) {
        answer[0] += 1;
        StringBuilder sb = new StringBuilder();
        for(Character c : s.toCharArray()) {
            if(c == '0') {
                answer[1] += 1;
            } else {
                sb.append(c);
            }
        }
        s = sb.toString();
        return Integer.toBinaryString(s.length());
    }
}
