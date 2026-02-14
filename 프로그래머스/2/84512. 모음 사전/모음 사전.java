import java.util.*;

class Solution {
    int answer;
    boolean flag;
    String[] arr = {"A","E","I","O","U"};
    public int solution(String word) {
        dfs("",word);
        return answer;
    }
    
    private void dfs(String cur, String word) {
        if (flag) return;
        if (word.equals(cur)) {
            flag = true;
            return;
        }
        if (cur.length() == 5) return;
        
        for (int i = 0; i < arr.length; i++) {
            answer++;
            dfs(cur + arr[i], word);
            if (flag) return;
        }
    
    }
}