import java.util.HashMap;

class Solution1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap <String, Integer> uncomMap = new HashMap <String, Integer> ();
        
        for (int i=0;i<completion.length;i++) 
        {
         if (uncomMap.containsKey(completion[i]))
         {
             int val = uncomMap.get(completion[i])+1;
             uncomMap.put(completion[i], val);
         }
         else
             uncomMap.put(completion[i], 1);
        }
        
        for (int i=0;i<participant.length;i++) 
        {
         if (uncomMap.containsKey(participant[i]))
         {
             int val = uncomMap.get(participant[i])-1;
             uncomMap.put(participant[i], val);
             if (uncomMap.get(participant[i])==-1)
                 answer = participant[i];
         }
         else
             answer = participant[i];
        }
        return answer;
    }
}