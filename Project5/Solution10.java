import java.util.ArrayList;

class Solution10 {

    ArrayList<String> list = new ArrayList<String>(); //���� �迭
    
    public int solution(int[][] baseball) {
        int answer = 0;
        
        Make_all_num();
        answer = Check_num_set(baseball);
                                         
        return answer;
    }
    
    
    public void Make_all_num() { //000~999 ���� ������ִ� �޼ҵ�
        int i, j, k;
        
        for(i=1; i<10; i++) {
            for(j=1; j<10; j++) {
                for(k=1; k<10; k++) {  
                    if (i==j||j==k||k==i) continue;
                    else list.add(""+i+j+k);
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
        //System.out.println(list.get(0));
        
        for (int i=0; i<baseball.length; i++) {
            lengthOfcomp = list.size();
            counter = 0;
            index = 0;
            baseball_num = Integer.toString(baseball[i][0]);
            st_ball = st_ball_check(baseball_num, list.get(index));
            
            while (counter < lengthOfcomp){
                counter++;
                st_ball = st_ball_check(baseball_num, list.get(index));
                if (st_ball[0]==baseball[i][1] && st_ball[1]==baseball[i][2]) {
                    index++;                        
                }
                else list.remove(index);
            }
        }
        answer = list.size();
        return answer;
    }
    
    
    public int[] st_ball_check (String baseball_num, String num) { // ��Ʈ����ũ���� ������ üũ
        int[] st_ball = new int[2];
        int i;
        
        for (i=0; i<3; i++) {
            //System.out.println(baseball_num.charAt(i));
            //System.out.println(num.charAt(i));
            if (baseball_num.charAt(i)==num.charAt(i)) st_ball[0]++;
        }
        for (i=0; i<3; i++) {
            if (baseball_num.contains(num.subSequence(i,i+1))) st_ball[1]++;
        }
        st_ball[1] = st_ball[1]-st_ball[0];
        
        return st_ball;
    }
}