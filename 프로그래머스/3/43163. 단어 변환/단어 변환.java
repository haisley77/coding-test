import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        // 처음에 변환 가능한 문자열 찾기
        for (int i = 0; i < words.length; i++) {
            if (check(begin, words[i]) == 1) {
                visited[i] = true;
                q.offer(new int[]{i, 1});
            }
        }
        
        int answer = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (words[cur[0]].equals(target)) {
                answer = cur[1];
                break;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                if (check(words[cur[0]], words[i]) == 1) {
                    visited[i] = true;
                    q.offer(new int[]{i, cur[1] + 1});
                }
            }
        }
        
        return answer;
    }
    
    private int check(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) cnt++;            
        }
        if (cnt == s1.length() - 1) return 1; // s1, s2 하나만 다르면
        return 0; // 나머지
    }
}