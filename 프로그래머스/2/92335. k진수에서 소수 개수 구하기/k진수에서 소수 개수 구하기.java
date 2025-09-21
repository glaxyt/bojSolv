class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // 양의 정수 n이 주어집니다. 이 숫자를 k진수로 바꿨을 때, 변환된 수 안에 아래 조건에 맞는 소수가 몇 개인지 알아보려 합니다.
        // 0을 포함하지않는 수여야한다.
         
        // 0가 나올 때마다 소수인지 판별하는 것.
        // 소수가 중복되어도 상관없다.
        
        String kjinbeop = Integer.toString(n, k);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < kjinbeop.length(); i++) {
            int num = kjinbeop.charAt(i) - '0';
            if (num == 0) {
                if (sb.length() == 0) continue;
                long result = Long.parseLong(sb.toString());
                if (isPrime(result)) answer++;
                sb = new StringBuilder();
            } else {
                sb.append(num);
            }
        }
        
        if (sb.length() != 0) {
            long result = Long.parseLong(sb.toString());
            if (isPrime(result)) answer++;
        }
        
        return answer;
    }
    
    private static boolean isPrime(long n) {
        if (n == 1) return false;
        if (n == 2) return true;
        
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}