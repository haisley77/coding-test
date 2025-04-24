import java.util.*;

class Solution {
    char[] arr = {'A','E','I','O','U'};
    ArrayList<String> dict = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        for (int i = 1; i <= 5; i++) {
            char[] res = new char[i];
            perm(0, i, res);
        }
        Collections.sort(dict);
        for (int i = 0; i < dict.size(); i++) {
            if (word.equals(dict.get(i))) {
                return i+1;
            }
        }
        return answer;
    }
    
    private void perm(int cnt, int n, char[] res) {
        if (cnt == n) {
            dict.add(new String(res));
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            res[cnt] = arr[i];
            perm(cnt+1,n,res);
        }
    }
}