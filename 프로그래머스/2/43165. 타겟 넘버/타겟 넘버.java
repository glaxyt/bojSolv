class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        // 완전 탐색해볼 예정.
        
        backtracking(numbers, 0, target, 0);
        return answer;
    }
    
    public void backtracking(int[] numbers, int idx, int target, int result) {
        if (idx == numbers.length) {
            if (result == target) answer++;
            return;
        }
        
        backtracking(numbers, idx+1, target, result + numbers[idx]);
        backtracking(numbers, idx+1, target, result - numbers[idx]);
    }
}