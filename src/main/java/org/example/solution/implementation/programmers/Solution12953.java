package org.example.solution.implementation.programmers;

import java.util.Arrays;

// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12953
public class Solution12953 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {2, 6, 8, 14};
        int[] arr2 = {1, 2, 3};

        System.out.println(solution.solution(arr1));
        System.out.println(solution.solution(arr2));
    }

    static class Solution {
        public int solution(int[] arr) {
            Arrays.sort(arr);
            int answer = arr[0];
            for(int i = 1; i < arr.length; ++i) {
                answer = this.lcm(answer, arr[i]);
            }

            return answer;
        }

        public int lcm(int a, int b) { // 최소공배수
            return a * b / this.gcd(a, b);
        }

        //    public int gcd(int a, int b) { // 최대공약수
//        int temp = 0;
//        if(a < b) {
//            temp = a;
//            a = b;
//            b = temp;
//        }
//
//        int gcd = 1;
//        while(b != 0) {
//            int remaider = a % b;
//            a = b;
//            b = remaider;
//        }
//
//        return gcd;
//    }
        public int gcd(int a, int b) {
            int temp = 0;
            if(a < b) {
                temp = a;
                a = b;
                b = temp;
            }

            if(b == 0) {
                return a;
            }

            return gcd(b, a%b);
        }
    }
}

// 풀이 방법: 주어진 숫자 배열을 오름차순으로 정렬하고, 앞에 두수의 최대 공약수를 통해 최소공배수 구함
// 참고: 최대 공약수는 유클리드 호제법을 통해 적은 시간복잡도로 구할 수 있고, gcd(a, b) = gcd(b, a % b) -> b가 0이 될때까지 반복
//      두 수의 최소 공배수는 두 수의 곱을 두 수의 최대공약수로 나누면 된다. lcm(a, b) = (a * b) / gcd(a, b)

//class Solution1 {
//    private List<Integer> primeList = new ArrayList<>();
//
//    public int solution(int[] arr) {
//        int answer = 0;
//
//        Arrays.sort(arr);
//
//        // 소수 구하기
//        int max = arr[arr.length - 1];
//        setPrimeList(max);
//        answer = arr[0];
//        for(int i = 1; i < arr.length; ++i) {
//            answer = this.getLeastCommonMultiple(answer, arr[i]);
//        }
//
//        return answer;
//    }
//
//    public int getLeastCommonMultiple(int a, int b) {
//        int leastCommonMultiple = 1;
//        boolean isNotEnd = true;
//        while(isNotEnd) {
//            for(int prime: this.primeList) {
//                if(a % prime == 0 && b % prime == 0) {
//                    leastCommonMultiple *= prime;
//                    a /= prime;
//                    b /= prime;
//                    break;
//                }
//
//                if(prime == this.primeList.get(this.primeList.size()-1)) {
//                    leastCommonMultiple *= (a * b);
//                    isNotEnd = false;
//                }
//            }
//        }
//
//        return leastCommonMultiple;
//    }
//
//    public void setPrimeList(int n) {
//        List<Integer> primeList = new ArrayList<>();
//
//        for(int i = 2; i <= n; ++i) {
//            boolean isPrime = true;
//            for(int j = 2; j <= Math.sqrt(i); ++j) {
//                if(i % j == 0) {
//                    isPrime = false;
//                }
//            }
//
//            if(isPrime) {
//                primeList.add(i);
//            }
//        }
//
//        this.primeList = primeList;
//    }
//}
