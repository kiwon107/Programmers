import java.util.Comparator;
import java.util.PriorityQueue;

class Solution16 {
    
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int num = 0;
        int date;
       
        Comparator<int[]> SuppliesComparator = new Comparator<int[]>() { // supplies ũ�Ⱑ ū ������ ť �켱���� ���� ����
        	
        	public int compare(int[] s1, int[] s2) {
        		return s2[1]-s1[1];
        	}
        };
        
        PriorityQueue<int[]> PleaseSolved = new PriorityQueue<> (SuppliesComparator); // �켱���� ť
        
        for (date=1; date < k; date++) {
        	--stock;
  
        	if (date == dates[num]) {
        		int[] pairs = {dates[num], supplies[num]};
        		PleaseSolved.add(pairs); //date�� �ؿܿ��� ������ ��¥ ���� ������ [dates, supplies] �� �켱���� ť�� �������
        		
        		if(num < dates.length-1)
        			++num;
        	}
        	
        	if (stock==0) {
        		stock += PleaseSolved.remove()[1]; // stock 0 �� �� ����, ���� ȿ������ Supplies ��ŭ ä������

        		++answer; // ä������ ������ answer 1 ����
        	}

        	}
        
        
        return answer;
    }
}