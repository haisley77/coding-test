import java.util.*;

class Solution {
    int[] res;
    boolean[] visited;
    int answer = 0;
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        char[] arr = numbers.toCharArray();
        int n = arr.length;
        
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n];
            res = new int[i];
            dfs(0,i,arr);
        }
        
        for (int num: set) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }
    
    private void dfs(int cnt, int n, char[] arr) {
        if (cnt == n) {
            String s = "";
            for (int i = 0; i < res.length; i++) {
                s += arr[res[i]];
            }
            int num = Integer.parseInt(s);
            set.add(num);
            return;
        }
        
       for (int i = 0; i < arr.length; i++) {
           if (visited[i]) continue;
           visited[i] = true;
           res[cnt] = i;
           dfs(cnt+1,n,arr);
           visited[i] = false;
       } 
    }
    
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        int start = 2;
        for (;num % start != 0; start++);
        return start == num;
    }
}