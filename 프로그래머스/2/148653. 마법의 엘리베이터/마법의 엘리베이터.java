class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int n1 = storey / 10 % 10;
            int n2 = storey % 10;
            
            if (n1 < 5) {
                if (n2 <= 5) {
                    storey -= n2;
                    answer += n2;
                    storey /= 10;
                } else {
                    storey += (10-n2);
                    answer += (10-n2);
                    storey /= 10;
                }
            } else {
                if (n2 < 5) {
                    storey -= n2;
                    answer += n2;
                    storey /= 10;
                } else {
                    storey += (10-n2);
                    answer += (10-n2);
                    storey /= 10;
                }
            }

        }

        return answer;
    }
}