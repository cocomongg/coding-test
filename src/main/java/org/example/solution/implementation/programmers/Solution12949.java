package org.example.solution.implementation.programmers;

public class Solution12949 {

    // 문제풀이: https://school.programmers.co.kr/learn/courses/30/lessons/12949
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr1 = {{1, 1, 1, 1}, {1, 1, 1, 1}};
        int[][] arr2 = {{2, 2}, {2, 2}, {2, 2}, {2, 2}};

        for(int[] arr : solution.solution(arr1, arr2)) {
            for(int e : arr) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int arr1Row = arr1.length;
            int arr1Col = arr1[0].length;

            int arr2Row = arr2.length;
            int arr2Col = arr2[0].length;

            int[][] answer = new int[arr1Row][arr2Col];

            for(int i = 0; i < arr1Row; ++i) {
                for(int j = 0; j < arr2Col; ++j) {
                    int sum = 0;
                    for(int k =0; k < arr2Row; ++k) {
                        sum += arr1[i][k] * arr2[k][j];
                    }

                    answer[i][j] = sum;
                }
            }

            return answer;
        }
    }
}
// 풀이방법: 실제 행렬 곱을 풀어서 인덱스에 맞게 계산되도록 구현 (쌩구현 문제로 해석)
