import java.util.Arrays;

class Solution6 {
    
    int iOne = 0;
        int iTwo = 0;
        int iThree = 0;
        int iNum = 0;
    
    public String solution(int[] numbers) {
        String answer = "";
        
        int i, j;
        
        int jOne = 0;
        int jTwo = 0;
        int jThree = 0;
        int jNum = 0;
        
        int Max;
        int MaxIndex;
        
        int helper;
        
        for (i=0; i<numbers.length; i++) {
            Max = numbers[i];
            
            Num_Check(Max);
            
            MaxIndex = i;
            
            for (j=i+1; j<numbers.length; j++) {
                if (numbers[j]>=0 && numbers[j]<10) {
                    jOne = numbers[j];
                    jNum = 1;
                }
                else if (numbers[j]>=10 && numbers[j]<100) {
                    jOne = numbers[j]/10;
                    jTwo = numbers[j]%10;
                    jNum = 2;
                }
                else if (numbers[j]>=100 && numbers[j]<1000) {
                    jOne = numbers[j]/100;
                    jTwo = (numbers[j]%100)/10;
                    jThree = (numbers[j]%100)%10;
                    jNum = 3;
                }
                
                if (Max == numbers[j] || iOne > jOne) // ù°�ڸ� ��
                    continue;
                else if (iOne < jOne) {
                    Max = numbers[j];
                    MaxIndex = j;
                    Num_Check(Max);
                }
                else {  
                    
                    if (iNum > jNum) {// numbers[i] �ڸ��� > numbers[j] �ڸ���
                        if (jNum == 1) {
                             if (iTwo > jOne) // �� ��� numbers[j] �� ���ڸ���
                                continue;
                            else if (iTwo < jOne) { 
                                Max = numbers[j];
                                MaxIndex = j;
                                Num_Check(Max);
                            }
                            else if (iThree > jOne)
                                continue;
                            else {
                                Max = numbers[j];
                                MaxIndex = j;
                                Num_Check(Max);
                            }    
                        } 
                        else { // �� ��� numbers[j] �� ���ڸ���
                            if (iTwo > jTwo)
                                continue;
                            else if (iTwo < jTwo) {
                                Max = numbers[j];
                                MaxIndex = j;
                                Num_Check(Max);
                            }
                            else if (iThree < jOne) {
                                Max = numbers[j];
                                MaxIndex = j;
                                Num_Check(Max);
                            }
                            else 
                                continue;  
                        }
                    }
                                               
                    else if (iNum < jNum) { // numbers[i] �ڸ��� < numbers[j] �ڸ���
                         if (iNum == 1) {
                             if (iOne > jTwo) // numbers[i] �� ���ڸ���
                                continue;
                            else if (iOne < jTwo) { 
                                Max = numbers[j];
                                MaxIndex = j;
                                Num_Check(Max);
                            }
                            else if (iOne > jThree)
                                continue;
                            else {
                                Max = numbers[j];
                                MaxIndex = j;
                                Num_Check(Max);
                            }    
                        } 
                        else { // numbers[i] �� ���ڸ���
                            if (iTwo > jTwo)
                                continue;
                            else if (iTwo < jTwo) {
                                Max = numbers[j];
                                MaxIndex = j;
                                Num_Check(Max);
                            }
                            else if (iThree < jOne) {
                                Max = numbers[j];
                                MaxIndex = j;
                                Num_Check(Max);
                            }
                            else 
                                continue; 
                        }
                    }
                    
                    else { // numbers[i] �ڸ��� == numbers[j] �ڸ���
                        if (iTwo > jTwo)
                            continue;
                        else if (iTwo < jTwo) {
                            Max = numbers[j];
                            MaxIndex = j;
                            Num_Check(Max);
                        }
                        else if (iThree > jThree) 
                            continue;
                        else if (iThree < jThree) {
                            Max = numbers[j];
                            MaxIndex = j;
                            Num_Check(Max);
                        }
                    }     
                }
            }
            
            helper = numbers[i];
            numbers[i] = Max;
            numbers[MaxIndex] = helper;
            answer = answer+numbers[i];
        }
        
        return answer;
    }
    
    public void Num_Check (int Max) {
        if (Max>=0 && Max<10) {
                iOne = Max;
                iNum = 1;
            }
            else if (Max>=10 && Max<100) {
                iOne = Max/10;
                iTwo = Max%10;
                iNum = 2;
            }
            else if (Max>=100 && Max<1000) {
                iOne = Max/100;
                iTwo = (Max%100)/10;
                iThree = (Max%100)%10;
                iNum = 3;
            }
    }
}