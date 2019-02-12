class Solution2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
                
        for(int i=0; i<completion.length; i++)
        {
            for(int j=0; j<participant.length; j++)
            {
                if (participant[j].equals(completion[i]))
                {
                    participant[j]="E";
                    break;
                }
            }
        }   
        
        for (int i=0;i<participant.length;i++)
        {
            System.out.println(participant[i]);
            if(!participant[i].equals("E"))
                answer = participant[i];
        }
            
        return answer;
    }
}