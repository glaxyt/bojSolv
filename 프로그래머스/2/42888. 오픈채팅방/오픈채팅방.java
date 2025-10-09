import java.util.*;

class Solution {
    
    public String[] solution(String[] record) {
        // 가상 닉네임이 보이는 관리자 창이 있다.
        // 
        Map<String, String> idByName = new HashMap<>();
        List<Boolean> inAndOut = new ArrayList<>();
        List<String> idRecord = new ArrayList<>();
        
        for (String r : record) {
            String[] data = r.split(" ");
            String cmd = data[0];
            String id = data[1];
            if (cmd.equals("Enter")) {
                idByName.put(id, data[2]);
                idRecord.add(id);
                inAndOut.add(true);
            } else if (cmd.equals("Leave")) {
                idRecord.add(id);
                inAndOut.add(false);
            } else if (cmd.equals("Change")) {
                idByName.put(id, data[2]);
            }
        }
        
        String[] answer = new String[idRecord.size()];

        
        for (int i = 0; i < idRecord.size(); i++) {
            String name = idByName.get(idRecord.get(i));
            if (inAndOut.get(i)) {
                answer[i] = name + "님이 들어왔습니다.";
            } else {
                answer[i] = name + "님이 나갔습니다.";
            }
        }
        
                
        return answer;
    }
}