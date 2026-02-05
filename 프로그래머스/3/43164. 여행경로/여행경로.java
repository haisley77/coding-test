import java.util.*;

class Solution {
    private boolean[] visited;
    private List<String> result;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        result = new ArrayList<>();
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(result);
        return result.get(0).split(" ");
    }
    private void dfs(int cnt, String start, String res, String[][] tickets) {
        if (cnt == tickets.length) {
            result.add(res);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(cnt+1, tickets[i][1], res + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}