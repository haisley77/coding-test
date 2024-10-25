class Solution {
    int[][] ratios = {{1,1},{2,3},{2,4},{3,4},{3,2},{4,2},{4,3}};
    public long solution(int[] weights) {
        long answer = 0;
        int[] arr = new int[1001];
        
        for (int i = 0; i < weights.length; i++) {
            arr[weights[i]]++;
        }
        
        for (int i = 0; i < weights.length; i++) {
            int cur = weights[i];
            arr[cur]--;
            
            for (int j = 0; j < ratios.length; j++) {
                int a = ratios[j][0];
                int b = ratios[j][1];
                
                int pair = cur * a / b;
                
                if (cur * a % b == 0 && pair <= 1001) {
                    answer += arr[pair];
                } 
            }


        }
        return answer;
    }

}