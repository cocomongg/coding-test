package org.example.solution.datastructure.programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42586
public class Solution42586 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        solution.printAnswer(progresses1, speeds1);

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        solution.printAnswer(progresses2, speeds2);
    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};
            List<Integer> answerList = new ArrayList<>();
            int limit = 100;

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < progresses.length; ++i ){
                double days = Math.ceil((double) (limit - progresses[i]) / speeds[i]);
                queue.add((int) days);
            }

            int count = 1;
            int currentValue = queue.poll();
            while(!queue.isEmpty()) { // 7, 3, 9
                Integer poll = queue.poll();
                if(currentValue < poll) {
                    currentValue = poll;
                    answerList.add(count);
                    count = 1;
                } else {
                    count++;
                }
            }

            answerList.add(count);
            answer = new int[answerList.size()];
            for(int i = 0; i < answerList.size(); ++i) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }

        public void printAnswer(int[] progresses, int[] speeds) {
            int[] solution = this.solution(progresses, speeds);
            for(int i : solution) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

// 풀이방법: 각 진행일정에 남은 일수들을 큐에 저장하여 큐를 소비하면서 문제 조건에 맞게 계산
