import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 0;
        // n / 3 장을 가져오고, 카드와 교환 가능한 코인 coin개를 가져온다.
        // 카드를 2장 가져오기, 동전을 소모해서 가질 수 있다.
        // 적힌 수의 합이 n+1이 되게 만들어서 카드 2장을 내야, 다음 라운드로 이동가능
        // 만일 넘어갈 수 없다면, 종료
        // 뽑는 기준이 어떤 것인지 정의해야합니다.
        // 백트래킹으로 가능한가? 둘 다 뽑기, 첫 번째 장만 뽑기, 두 번째 장만 뽑기, 아무것도 안뽑기,
        // 4^500 이 되어버린다.
        // 그럼 가능하지않다.
        // 그리디한 방법이 존재할 것이다.
        // 오름차순으로 정렬해서 짝을 찾아야한다.
        // n은 996까지 최대이다.
        // 짝이 맺어질 수 있는 애들부터 가져와야한다.
        // 손에 카드 + 뽑힐 카드
        // 뽑힐 카드 + 추후에 뽑힐 카드
        int n = cards.length;
        int target = n + 1;
        
        Set<Integer> hand = new HashSet<>();
        for (int i = 0; i < n / 3; i++) {
            hand.add(cards[i]);
        }
        
        Set<Integer> drawn = new HashSet<>();
        
        int round = 1;
        int idx = n / 3;
        
        while (idx < n) {
            drawn.add(cards[idx]);
            drawn.add(cards[idx + 1]);
            idx += 2;
            
            boolean canContinue = false;
            
            if (findAndRemovePair(hand, hand, target)) {
                canContinue = true;
            } else if (coin >= 1 && findAndRemovePair(hand, drawn, target)) {
                coin--;
                canContinue = true;
            } else if (coin >= 2 && findAndRemovePair(drawn, drawn, target)) {
                coin -= 2;
                canContinue = true;
            }
            
            if (!canContinue) break;
            round++;
        }
        
        return round;
    }
    
    // set1과 set2에서 합이 target인 쌍을 찾아 제거
    private boolean findAndRemovePair(Set<Integer> set1, Set<Integer> set2, int target) {
        for (int card : set1) {
            int need = target - card;
            if (set2.contains(need)) {
                set1.remove(card);
                set2.remove(need);
                return true;
            }
        }
        return false;
    }
}