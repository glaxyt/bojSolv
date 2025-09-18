import java.util.*;

class Solution {
    static final int EMOTICON_PLUS_FEE = 5400;
    static int[] discounts = new int[]{10, 20, 30, 40};
    static int[] discountByPos;
    static Payment maxPayment = new Payment(Integer.MIN_VALUE, Integer.MIN_VALUE);
    public int[] solution(int[][] users, int[] emoticons) {
        // 목표
        // 1. 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
        // 2. 이모티콘 판매액을 최대한 늘리는 것.
        // 플러스 서비스 가입자를 최대한 늘려보려고 노력하되, 최대 사용자 수가 같다면, 판매액을 늘려야한다.
        // 가입자를 많이 만드는 방법
        //
        // 판매액을 최대한 늘리는 방법
        // 
        
        // 사용자들의 선택 기준
        // 1. 자신의 기준보다 일정 비율 이상 할인하면 모두 구매한다.
        // 2. 그러나 구매하려는 이모티콘의 가격의 합이 자신의 기준 비용 이상이면 플러스 가입한다.
        
        
        // 이모티콘 최대 7개, 사용자 최대 100명, 할인율 종류 최대 4개,(이제야 발견함.. 100개인줄..)
        discountByPos = new int[emoticons.length];
        dfs(emoticons.length, 0, users, emoticons);
        return maxPayment.printData();
    }
    
    private static void dfs(int n, int cnt, int[][] users, int[] emoticons) {
        if (cnt == n) {
            Payment curPayment = getResultOfDiscount(users, emoticons);

            if (maxPayment.peo < curPayment.peo) {
                maxPayment = curPayment;
            } else if (maxPayment.peo == curPayment.peo) {
                if (maxPayment.totalPayFee < curPayment.totalPayFee) {
                    maxPayment = curPayment;
                }
            }
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            discountByPos[cnt] = discounts[i];
            dfs(n, cnt + 1, users, emoticons);
        }
    }
    
    private static Payment getResultOfDiscount(int[][] users, int[] emoticons) {
        int peo = 0;
        int totalPayFee = 0;
        
        for (int userIdx = 0; userIdx < users.length; userIdx++) {
            int curUserPay = 0;
            int userLimitDis = users[userIdx][0];
            int userLimitPay = users[userIdx][1];
            for (int emotIdx = 0; emotIdx < emoticons.length; emotIdx++) {
                int discount = discountByPos[emotIdx];

                if (userLimitDis <= discount) {
                    curUserPay += (emoticons[emotIdx] * (100 - discount)) / 100;
                }
            }

            if (userLimitPay <= curUserPay) {
                peo++;
            } else {
                totalPayFee += curUserPay;
            }
        }
        
        return new Payment(peo, totalPayFee);
    }
}

class Payment {
    int peo;
    int totalPayFee;
    
    public Payment(int peo, int totalPayFee) {
        this.peo = peo;
        this.totalPayFee = totalPayFee;
    }
    
    public int[] printData() {
        return new int[]{peo, totalPayFee};
    }
}