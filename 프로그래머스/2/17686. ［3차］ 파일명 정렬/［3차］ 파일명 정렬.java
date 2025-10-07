import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        // System.out.println((int) '.');
        
        List<Meta> list = new ArrayList<>();
        for (int idx = 0; idx < files.length; idx++) {
            String file = files[idx];
            StringBuilder head = new StringBuilder();
            int startIdx = 0;
            StringBuilder number = new StringBuilder();
            for (int i = 0; i < file.length(); i++) {
                int charToInt = file.charAt(i);
                
                if (charToInt >= 48 && charToInt <= 57) {
                    
                    for (int j = i; j < file.length(); j++) {
                        
                        int charToIntNumber = file.charAt(j);
                        if (charToIntNumber < 48 || charToIntNumber > 57) {
                            startIdx = j;
                            break;
                        }
                        number.append(file.charAt(j));
                        if (j == file.length() - 1) {
                           startIdx = file.length();
                        }           
                    }
                    
                    break;
                }
                head.append(file.charAt(i));
            }
            
            Meta meta = new Meta(idx, head.toString(), number.toString(), file.substring(startIdx, file.length()));    list.add(meta);
            
        }
        
        list.sort((a, b) -> {
            int r1 = a.head.toLowerCase().compareTo(b.head.toLowerCase());
            if (r1 != 0) return r1;
            int r2 = Integer.parseInt(a.number) - Integer.parseInt(b.number);
            if (r2 != 0) return r2;
            return a.inputOrder - b.inputOrder;
        });
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).print();
        }
        // HEAD 추출 사전순(대소문자 구분X)
        
        // NUMBER 추출 (숫자 정렬)
        
        // TAIL (들어온 순서.)
        
        return answer;
    }
}

class Meta {
    int inputOrder;
    String head;
    String number;
    String tail;
    
    public Meta(int inputOrder, String head, String number, String tail) {
        this.inputOrder = inputOrder;
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
    
    public String print() {
        return head+number+tail;
    }
}