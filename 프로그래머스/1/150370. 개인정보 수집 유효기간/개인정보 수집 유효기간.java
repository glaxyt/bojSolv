import java.util.*;

class Solution {
    static final int START_YEAR = 2000;
    static final int START_MONTH = 1;
    static final int START_DAY = 1;
    static final int DAY_OF_MONTH = 28;
    static final int MONTH_OF_YEAR = 12;
    static Map<String, Integer> termInfo = new HashMap<>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        
        // 약관의 종류에 따라 변한다. 작성 날짜 -1일을 해야한다.
        // 달의 변경도 신경써야한다.
        // 오늘 날짜를 기점으로 이미 약관의 날짜를 넘어섰다면 삭제해야한다.
        // 오늘 날짜와 약관 작성 날짜를 비교한다.
        // 한 달은 28일로 설정한다.
        
        for (String term : terms) {
            String[] termData = term.split(" ");
            String termName = termData[0];
            Integer termDuration = Integer.parseInt(termData[1]) * DAY_OF_MONTH - 1;
            termInfo.put(termName, termDuration);
        }
        
        List<Integer> privacieHaveToRemove = new ArrayList<>();
        for (int idx = 0; idx < privacies.length; idx++) {
            String privacie = privacies[idx];
            if (validateMonthDiff(today, privacie)) privacieHaveToRemove.add(idx+1);
        }
        
        int[] answer = new int[privacieHaveToRemove.size()];
        for (int idx = 0; idx < privacieHaveToRemove.size(); idx++) {
            answer[idx] = privacieHaveToRemove.get(idx);
        }
        
        return answer;
    }
    
    
    private static boolean validateMonthDiff(String now, String privacie) {
        String[] finedTermData = privacie.split(" ");

        int[] privacyDate = Arrays.stream(finedTermData[0].split("\\."))
            .mapToInt(Integer::parseInt).toArray();
        int termDuration = termInfo.get(finedTermData[1]);
        
        int[] nowDate = Arrays.stream(now.split("\\."))
            .mapToInt(Integer::parseInt).toArray();
        
        int nowDayCnt = getDayByDate(nowDate[0], nowDate[1], nowDate[2]);
        int privacyDayCnt = getDayByDate(privacyDate[0], privacyDate[1], privacyDate[2]);
        // 모두 그 해의 2000년 1월 1일 기점으로 계산한다.
        
        int diffWithDates = nowDayCnt - privacyDayCnt;
        
        if (diffWithDates > termDuration) return true;
        return false;
        
    }
    
    private static int getDayByDate(int year, int month, int day) {
        int result = 0;
        result += (year - START_YEAR) * DAY_OF_MONTH * MONTH_OF_YEAR;
        result += (month - START_MONTH) * DAY_OF_MONTH;
        result += (day - START_DAY);
        return result;
    }
}