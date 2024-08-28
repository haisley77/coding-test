import java.util.*;
class Node {
    String now;
    int att;
    Node(String now, int att) {
        this.now = now;
        this.att = att;
    }
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 1;
        
        if (begin.length() != target.length()) return 0;
        if (begin.length() != words[0].length()) return 0;
        
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) flag = true;
        }
        if (!flag) return 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin,0));
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            String now = cur.now;
            if (now.equals(target)) return cur.att;
            
            for (int i = 0; i < words.length; i++) {
                
                if (visited[i]) continue;
                
                int cnt = 0;
                for (int j = 0; j < now.length(); j++) {
                    if (now.charAt(j) == words[i].charAt(j)) cnt++;
                }
                
                if (cnt == now.length() - 1) {
                    visited[i] = true;
                    q.offer(new Node(words[i], cur.att+1));
                }
                
            }
            
        }
        
        return answer;
    }
}