class Solution {
    int res = 0;
    public int solution(int[] numbers, int target) {
        char[] oper = new char[numbers.length];
        dfs(numbers,target,oper,0);
        return res;
    }
    private void dfs(int[] numbers, int target, char[] oper, int cnt) {
        if (cnt == numbers.length) {
            int sum = 0;
            for (int i = 0; i < oper.length; i++) {
                if (oper[i] == '-') {
                    sum -= numbers[i];
                }
                if (oper[i] == '+') {
                    sum += numbers[i];
                }
            }
            if (target == sum) res++;
            return;
        }
        
        oper[cnt] = '-';
        dfs(numbers,target,oper,cnt+1);
        oper[cnt] = '+';
        dfs(numbers,target,oper,cnt+1);
    }
}