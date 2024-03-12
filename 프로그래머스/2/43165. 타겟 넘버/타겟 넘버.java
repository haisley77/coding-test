class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        char[] oper = new char[numbers.length];
        dfs(numbers, oper, 0, target);
        return answer;
    }
    
    private void dfs(int[] numbers, char[] oper, int cnt, int target) {
        // 탈출
        if (cnt == numbers.length) {
            int res = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (oper[i] == '-') {
                    res -= numbers[i];
                } else {
                    res += numbers[i];
                }
            }
            if (res == target) answer++;
            return;
        }
        
        oper[cnt] = '-';
        dfs(numbers,oper,cnt+1,target);
        oper[cnt] = '+';
        dfs(numbers,oper,cnt+1,target);
        
        
    }
}