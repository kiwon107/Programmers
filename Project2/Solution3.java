class Solution3 {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        answer[0] = 0;
        
        for (int i=1; i<heights.length; i++)
        {
            int lim = 0;
            while (i-lim>0)
            {
                lim = lim+1;
                if (heights[i]<heights[i-lim])
                {
                    answer[i] = (i-lim+1);
                    break;
                }
                else if (i-lim==0)
                    answer[i] = 0;
            }
        }
        return answer;
    }
}