import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution8 {
    
    public String solution(int[] numbers) {
        String answer = "";
        int i;
        ArrayList<String> list = new ArrayList<String>();
            
        for (i=0; i<numbers.length;i++) {
            list.add(Integer.toString(numbers[i]));           
        }
        
        Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String p1, String p2) {
				String type1=""+p1+p2;
				String type2=""+p2+p1;
				
				if (Integer.parseInt(type1)<Integer.parseInt(type2)) { //요걸 만족하면 바꿔라?
					return 1; 
				}
				else if (Integer.parseInt(type1)>Integer.parseInt(type2)) {
					return -1;
				}
				// TODO Auto-generated method stub
				else
				return 0;
			}
        });
        
        for (i=0; i<list.size();i++) {
            answer = answer + list.get(i);         
        }
        
        return answer;
    }
}