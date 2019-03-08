class Solution12 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int flag = 0;
        String a, b;
       
        
        for (int i=0; i<phone_book.length-1; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                
                if(phone_book[i].length() < phone_book[j].length() ) {
                    a = phone_book[i];
                    b = (String) phone_book[j].subSequence(0, a.length());
                }
                else {
                    a = phone_book[j];
                    b = (String) phone_book[i].subSequence(0, a.length());
                }
                
            
                if (a.contains(b)) {
                    answer = false;
                    flag = 1;
                    break;
                }
                
                
            }
            
            if (flag == 1)
            	break;
        }
        
        return answer;
    }
}