import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int diamond;
        int iron;
        int stone;
        Node(int diamond, int iron, int stone) {
            this.diamond = this.diamond;
            this.iron = iron;
            this.stone =stone;
        }
        
        @Override
        public int compareTo(Node node){
            if (this.diamond != node.diamond) return Integer.compare(node.diamond, this.diamond);
            if (this.iron != node.iron) return Integer.compare(node.iron, this.iron);
            return Integer.compare(node.stone, this.stone);
        }
    }
    int[][] dirs = {{1,1,1},{5,1,1},{25,5,1}};
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int max = (picks[0] + picks[1] + picks[2]) * 5;
        if (minerals.length > max) {
            minerals = Arrays.copyOf(minerals, max);
        } 


        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < minerals.length; i += 5) {
            Node node = new Node(0, 0, 0);
            for (int j = i; j < minerals.length && j < i + 5; j++) {
                if (minerals[j].equals("diamond")) node.diamond++;
                else if (minerals[j].equals("iron")) node.iron++;
                else if (minerals[j].equals("stone")) node.stone++;
            }
            list.add(node);
        }
        
        
        Collections.sort(list);
        
        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (index < list.size() && picks[i] > 0) {
                Node cur = list.get(index);
                answer += dirs[i][0] * cur.diamond;
                answer += dirs[i][1] * cur.iron;
                answer += dirs[i][2] * cur.stone;
                index++;
                picks[i]--;
            }
        }
        
        return answer;
    }
    

}