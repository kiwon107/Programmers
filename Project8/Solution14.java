import java.util.ArrayList;

class Solution14 {
    
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int iter = 0;
        
        ArrayList<Integer> heap = new ArrayList<>();
        
        heap.add(0); // 0��° �ε��� ����
        heap.add(stock); // 1��° �ε������� ����
        
        for (int i=1; i<(Math.pow(2, supplies.length)); i++){ // �ּ��� ����
            
            if(i+1>((Math.pow(2,iter+1)))) 
                ++iter;
                
            heap.add(heap.get(i)+0);
            heap.add(heap.get(i)+supplies[iter]);
        }
        
        answer = check_answer(heap, supplies.length, k);
        
        return answer;
    }
    
    public int check_answer (ArrayList heap, int length, int k) { // ���� �� ������ ��� ���� k �� ��
     
        int min = length;
        String identifier;
        int a = (int) Math.pow(2, length);
        int counter;
            
        for (int i=0; i<Math.pow(2, length); i++) {
            if((int) heap.get(a+i)>=k) {
                
                identifier = Integer.toString(i,2); // decimal to binary
                counter = identifier.length() - identifier.replace("1", "").length(); // 2�������� 1 ���� ��
                
                if (min>counter)
                	min = counter;
            }
        }
        
        return min;
    }
}