import java.util.Comparator;
import java.util.PriorityQueue;

class Solution16 {
    
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int num = 0;
        int date;
       
        Comparator<int[]> SuppliesComparator = new Comparator<int[]>() { // supplies 크기가 큰 순으로 큐 우선순위 집어 넣음
        	
        	public int compare(int[] s1, int[] s2) {
        		return s2[1]-s1[1];
        	}
        };
        
        PriorityQueue<int[]> PleaseSolved = new PriorityQueue<> (SuppliesComparator); // 우선순위 큐
        
        for (date=1; date < k; date++) {
        	--stock;
  
        	if (date == dates[num]) {
        		int[] pairs = {dates[num], supplies[num]};
        		PleaseSolved.add(pairs); //date가 해외에서 보내는 날짜 지날 때마다 [dates, supplies] 쌍 우선순위 큐에 집어넣음
        		
        		if(num < dates.length-1)
        			++num;
        	}
        	
        	if (stock==0) {
        		stock += PleaseSolved.remove()[1]; // stock 0 될 때 마다, 가장 효율적인 Supplies 만큼 채워넣음

        		++answer; // 채워넣을 때마다 answer 1 증가
        	}

        	}
        
        
        return answer;
    }
}