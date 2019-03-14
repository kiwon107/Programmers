class Solution15 {
    
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int date;
        int num1 = 0;
        int num2 = 0;
        
        for (date = 1; date <= k; date++) {
        	--stock;
        	
        	if (date == dates[num1]) {
        		
        		if (stock == 0) {
        			stock += supplies[num2];
        			num1++;
        			if(num1 == dates.length)
        				num1 = dates.length-1;
        			num2++;
        			answer++;
        		}
        		
        		else {
        			num1++;
        			if(num1 == dates.length)
        				num1 = dates.length-1;
        			num2++;
        			continue;
        		}
        			
        	}
        	
        	else {
        		
        		if (stock == 0) {
        			stock += (supplies[num2-1]);
        			answer++;
        		}
        	}        	
        }
        
        
        return answer;
    }
}