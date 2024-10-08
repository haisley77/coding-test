import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        String s;
        int cnt;
        Node(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cnt != o.cnt) return Integer.compare(o.cnt, this.cnt);
            if (this.s.length() != o.s.length()) return Integer.compare(o.s.length(), this.s.length());
            return this.s.compareTo(o.s);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Node> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue;
            map.put(word, map.getOrDefault(word,9)+1);
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            String word = entry.getKey();
            int cnt = entry.getValue();
            arr.add(new Node(word, cnt));
        }
        Collections.sort(arr);
        for (Node cur: arr) {
            sb.append(cur.s).append("\n");
        }
        System.out.println(sb);

    }
}
