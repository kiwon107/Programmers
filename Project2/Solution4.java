import java.util.Stack;

public class Solution4 {

    Stack st = new Stack();
    
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        answer[0] = 0;
        int i, j, current;
        Stack_adder(0, heights.length, heights);
        
        for (i=heights.length-1;i>-1;i--)
        {
            current = (int)st.pop();
            
            for (j=i-1;j>-1;j--)
            {
                if (heights[j]>current)
                {
                    answer[i] = j+1;
                    break;
                }
            }
            
            if (j==-1)
                answer[i] = 0;
                
        }
        
        return answer;
    }
    
    public void Stack_adder(int from, int len, int[] heights) {
        for (int i=from;i<len;i++)
            st.push(heights[i]);
    }
}
