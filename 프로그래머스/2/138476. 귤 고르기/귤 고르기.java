import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int n;
        int cnt;
        Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Node node) {
            return Integer.compare(node.cnt, this.cnt);
        }
        
    }
    public int solution(int k, int[] tangerine) {

        Node[] arr = new Node[10000001];
        for (int i = 0; i < tangerine.length; i++) {
            if (arr[tangerine[i]] == null) {
                arr[tangerine[i]] = new Node(i,0);
            }
            arr[tangerine[i]].cnt++;
        }
        
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) continue;
            list.add(arr[i]);
        }
        
        Collections.sort(list);
        
        int answer = 0;
        int t = 0;
        int index = 0;
        while (true) {
            Node cur = list.get(index);
            answer++;
            t += cur.cnt;
            index++;
            
            if (t >= k) break;
        }
        return answer;
    }
}