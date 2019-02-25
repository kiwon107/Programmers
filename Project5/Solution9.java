import java.util.ArrayList;

class Solution9 {
    
    ArrayList<String> list = new ArrayList<String>(); //���� �迭
    
    public int solution(int[][] baseball) {
        int answer = 0;
        
        Make_all_num();
        answer = Check_num_set(baseball);
                                         
        return answer;
    }
    
    public void Make_all_num() { //000~999 ���� ������ִ� �޼ҵ�
        
        int i, j, k;
        
        for(i=0; i<10; i++) {
            for(j=0; j<10; j++) {
                for(k=0; k<10; k++) {
                    list.add(""+i+j+k);
                }
            }
        }
    }
    
    public int Check_num_set(int[][] baseball) { //baseball ���� ���� �����ϴ��� Ȯ��. �������ϸ� ����Ʈ���� ����.
        int lengthOfcomp; //����Ʈ ���� üũ ����
        int counter; //while�� ī����
        int index; //����Ʈ ���� �ε���
        int answer;
        int[] st_ball = new int[2]; //��Ʈ����ũ, ��
        String baseball_num; // baseball ���� String ������ ��ȯ
        
        for (int i=0; i<baseball.length; i++) {
            lengthOfcomp = list.size();
            counter = 0;
            index = 0;
            baseball_num = Integer.toString(baseball[i][0]);
                
            if (baseball[i][1]==0 && baseball[i][2]==0) {
                while (counter < lengthOfcomp){
                    counter++;
                    st_ball = st_ball_check(baseball_num, list.get(index));
                    if (st_ball[0]==0 && st_ball[1]==0) {
                        index++;                        
                    }
                    else list.remove(index);
                }
            }
            else if (baseball[i][1]==0 && baseball[i][2]==1) {
                while (counter < lengthOfcomp){
                    counter++;
                    st_ball = st_ball_check(baseball_num, list.get(index));
                    if (st_ball[0]==0 && st_ball[1]==1) {  
                        index++;
                    }
                    else list.remove(index);
                }
            }
            else if(baseball[i][1]==0 && baseball[i][2]==2) {
                while (counter < lengthOfcomp){
                    counter++;
                    st_ball = st_ball_check(baseball_num, list.get(index));
                    if (st_ball[0]==0 && st_ball[1]==2) {               
                        index++;
                    }
                    else list.remove(index);
                }
            }
            else if(baseball[i][1]==0 && baseball[i][2]==3) {
                while (counter < lengthOfcomp){
                    counter++;
                    st_ball = st_ball_check(baseball_num, list.get(index));
                    if (st_ball[0]==0 && st_ball[1]==3) {
                        index++;
                    }
                    else list.remove(index);
                }
            }
            else if(baseball[i][1]==1 && baseball[i][2]==0) {
                while (counter < lengthOfcomp){
                    counter++;
                    st_ball = st_ball_check(baseball_num, list.get(index));
                    if (st_ball[0]==1 && st_ball[1]==0) {
                        index++;                        
                    }
                    else list.remove(index);
                }
            }
            else if(baseball[i][1]==1 && baseball[i][2]==1) {
                while (counter < lengthOfcomp){
                    counter++;
                    st_ball = st_ball_check(baseball_num, list.get(index));
                    if (st_ball[0]==1 && st_ball[1]==1) {
                        index++;              
                    }
                    else list.remove(index);  
                }
            }
            else if(baseball[i][1]==1 && baseball[i][2]==2) {
                while (counter < lengthOfcomp){
                    counter++;
                    st_ball = st_ball_check(baseball_num, list.get(index));
                    if (st_ball[0]==1 && st_ball[1]==2) {
                        index++;                        
                    }
                    else list.remove(index);
                }
            }
            else if(baseball[i][1]==2 && baseball[i][2]==0) {
                while (counter < lengthOfcomp){
                    counter++;
                    st_ball = st_ball_check(baseball_num, list.get(index));
                    if (st_ball[0]==2 && st_ball[1]==0) {
                        index++;                  
                    }
                    else list.remove(index);
                }
            }
            else {
                list.clear();
                list.add(Integer.toString(baseball[i][0]));
                break;
            }          
        }
        answer = list.size();
        return answer;
    }
    
    public int[] st_ball_check (String baseball_num, String num) { // ��Ʈ����ũ���� ������ üũ
        int[] st_ball = new int[2];
        int i;
        for (i=0; i<3; i++) {
            if (baseball_num.charAt(i)==num.charAt(i)) st_ball[0]++;
        }
        for (i=0; i<3; i++) {
            if (baseball_num.contains(num.subSequence(i,i+1))) st_ball[1]++;
        }
        st_ball[1] = st_ball[1]-st_ball[0];
        
        return st_ball;
    }
    
    /*
   public String Check_strike(int[][] baseball) {
      
       String num;
       
       for(int i=0; i<baseball.length; i++) {
           
           num = Integer.toString(baseball[i][0]);
           
           if (baseball[i][1]==0 && baseball[i][1]==0) {
               continue;
           }
           else if (baseball[i][1]==0 && baseball[i][1]==1) {
               Strike_list.add("E"+num.charAt(0)+"E");
               Strike_list.add("E"+"E"+num.charAt(0));
               Strike_list.add(num.charAt(1)+"E"+"E");
               Strike_list.add("E"+"E"+num.charAt(1));
               Strike_list.add(num.charAt(2)+"E"+"E");
               Strike_list.add("E"+num.charAt(2)+"E");
           }
           else if (baseball[i][1]==0 && baseball[i][1]==) {
               Strike_list.add("E"+num.charAt(0)+num.charAt(1));
               Strike_list.add("E"+num.charAt(2)+num.charAt(1));
               Strike_list.add("E"+num.charAt(2)+num.charAt(0));
               Strike_list.add(num.charAt(1)+"E"+num.charAt(0));
               Strike_list.add(num.charAt(2)+"E"+num.charAt(0));
               Strike_list.add(num.charAt(2)+"E"+num.charAt(1));
               Strike_list.add(num.charAt(1)+num.charAt(0)+"E");
               Strike_list.add(num.charAt(1)+num.charAt(2)+"E");
               Strike_list.add(num.charAt(2)+num.charAt(0)+"E");
           }
           else if (baseball[i][1]==2) {
               Strike_list.add(num.charAt(0)+num.charAt(1)+"E");
               Strike_list.add(num.charAt(0)+"E"+num.charAt(2));
               Strike_list.add("E"+num.charAt(1)+num.charAt(2));
               level = 2;
           }
           else {
               Strike_list.add(num.charAt(0)+num.charAt(1)+num.charAt(2));
               level = 3;
           }
       }
    }
    
    public string Find_ball(int[][] baseball) {
        
    }
    */
}