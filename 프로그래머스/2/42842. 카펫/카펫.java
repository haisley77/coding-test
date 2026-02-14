class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int size = brown + yellow;
        
        for (int i = 2; i < size / 2; i++) {
            if (size % i != 0) continue;
            
            int a = i;          // 세로
            int b = size / i;   // 가로
            
            if (yellow == (a - 2) * (b - 2)) {
                answer[0] = b;
                answer[1] = a;
                break;
            }
            
        }
        return answer;
    }
}