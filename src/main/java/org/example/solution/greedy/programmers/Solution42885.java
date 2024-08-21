package org.example.solution.greedy.programmers;

import java.util.Arrays;

// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42885
public class Solution42885 {

    public static void main(String[] args) {
        int[] people = new int[]{70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));

        people = new int[]{70, 80, 50};
        System.out.println(solution(people, limit));

        people = new int[]{20, 60, 70, 80, 30};
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int idx=0;
        for(int i = people.length-1; i >= idx; i--){
            if(people[i] + people[idx] <= limit){
                answer++;
                idx++;
            }
            else answer++;
        }

        return answer;
    }
}

//문제풀이: 배열을 오름차순으로 정렬 후, 최대 2명이 보트에 탈 수 있기 때문에 최소와 최대의 합으로 풀어야함.
//참고:    오름차순으로 정렬된 배열에서 0번째 요소와 제일 끝에 요소를 더했을때 limit을 넘으면 1번째 요소와
//        마지막 요소를 더해도 limit을 넘게된다 (오름차순으로 졍렬 되었기 때문에)
//        오름 차순 정렬 후 최소와 최대를 더해야 문제의 조건에 맞는 최소값을 구할 수 있고, 위 참고 사항을 생각을 해야 된다.
