class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0,0,numbers,target);
        return answer;
    }
    
    private void dfs(int cur, int cnt, int[] numbers, int target) {
        if (cnt == numbers.length) {
            if (cur == target) answer++;
            return;
        }
        
        dfs(cur + numbers[cnt], cnt + 1, numbers, target);
        dfs(cur - numbers[cnt], cnt + 1, numbers, target);
    }
}