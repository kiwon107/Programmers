class Solution7 {
    
    public String solution(int[] numbers) {
        String answer = "";
        int i, j, buffer;
        String type1, type2;
        
        for (i=0;i<numbers.length-1;i++) {
            for (j=i+1;j<numbers.length;j++) {
                type1 = ""+numbers[i]+numbers[j];
                type2 = ""+numbers[j]+numbers[i];
                
                if (Integer.parseInt(type1)<Integer.parseInt(type2)) {
                    buffer = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = buffer;
                }
                
            }
            answer = answer+numbers[i];
        }
        
        answer = answer+numbers[i];
        
        return answer;
    }
    
}