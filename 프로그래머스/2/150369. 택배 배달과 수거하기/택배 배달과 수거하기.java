class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        // 택배를 배달하면서, 빈 재활용 택배 상자는 수거해야한다.
        // 물류창고와 집들로 이루어져있으며,
        // i는 물류창고로부터 집까지의 거리이며, 집과 집의 거리는 j-i 이다.
        // 트럭에는 넣을 수 있는 택배 상자의 개수가 정해져있다.
        // 배달을 하는데 최소 이동 거리를 구해야한다.
        // 완료 조건은 배달을 모두하는 것과 모든 빈 재활용 택배 상자를 수거해야한다.
        // 그리디로 가능한가?
        // 무조건 먼 거리의 집부터 들려서 배달하는 것이 좋다. 택배는 최대치를 갖고 가는게 좋다. 가면서 뿌리면 되기 때문
        // 이동하면서 배달이 가능한 곳이 있다면 미리 배달하는게 좋다.(먼거리 부터)
        
        // 쭉 갔다가 돌아오는 로직이 실패하는 이유가 뭘까?
        // 건물 간의 이동이 필요한가?
        // 1 0 0 0 3 0 0 2
        // 0 2 2 0 0 2 2 4
        // 
        // 만일 돌아오는 길에 
        // 
        
        
        
        // 가장 먼거리를 가지고 있는 택배 도착지를 찾는다.
        // 가장 먼거리를 가지고 있는 택배 수거지를 찾는다.
        int lastDeliverPos = updateMaxDisToDeliver(deliveries.length-1, deliveries);
        int lastPickUpPos = updateMaxDisToPickUp(pickups.length-1, pickups);    
        
//         int deliverCnt = 0;
//         for (int i=0; i<=lastDeliverPos; i++) {
//             if (deliveries[i] > 0) deliverCnt += deliveries[i];
//         }
        
//         int pickUpCnt = 0;
//         for (int i=0; i<=lastPickUpPos; i++) {
//             if (pickups[i] > 0) pickUpCnt += pickups[i];
//         }
            
        while (lastDeliverPos > -1 || lastPickUpPos > -1) {         
            // 이 중에서 가장 긴 거리를 고정으로 가야한다.
            // 그래서 이번 움직임에서는 가장 긴거리의 2배가 된다.
            answer += (Math.max(lastDeliverPos, lastPickUpPos) + 1) * 2;
            // System.out.println("deliv: " + lastDeliverPos + ", " + "pick: " + lastPickUpPos);
            
            // 이제 이 긴 거리를 이동하면서 수거와 배달을 수행해야한다.
            // 못 배달하거나, 못 싣고오는 경우는 없다.
            // cap만큼 삭제해야한다.
            int availableDeliver = cap;
            // 순회 조회가 너무 긴가? 라는 생각도 드네 100,000 차라리 마지막 값을 기억한다면 도움이 될 것 같다.
            // 배달해야하는 택배 개수 감소 로직
            for (int idx = lastDeliverPos; idx > -1; idx--) {
                if (availableDeliver == 0) break;
                
                int haveToDeliver = deliveries[idx];
                if (haveToDeliver == 0) continue;
                
                // System.out.println("deliv: " + idx);
                
                if (availableDeliver >= haveToDeliver) {
                    availableDeliver -= haveToDeliver;
                    deliveries[idx] = 0;
                } else {
                    deliveries[idx] -= availableDeliver;
                    break;
                }
            }
            
            int availablePickUp = cap;
            for (int idx = lastPickUpPos; idx > -1; idx--) {
                if (availablePickUp == 0) break;
                
                int haveToPickUp = pickups[idx];
                if (haveToPickUp == 0) continue;
                
                // System.out.println("pickup: " + idx);
                
                if (availablePickUp >= haveToPickUp) {
                    availablePickUp -= haveToPickUp;
                    pickups[idx] = 0;
                } else {
                    pickups[idx] -= availablePickUp;
                    break;
                }
            }                
            lastDeliverPos = updateMaxDisToDeliver(lastDeliverPos, deliveries);
            lastPickUpPos = updateMaxDisToPickUp(lastPickUpPos, pickups);
        }
        
        return answer;
    }
    
    
    private static int updateMaxDisToDeliver(int lastDeliverPos, int[] deliveries) {
        for (int i = lastDeliverPos; i > -1; i--) {
            if (deliveries[i] > 0) {
                return i;
            }
        }
        return -1;
    }
    
    private static int updateMaxDisToPickUp(int lastPickUpPos, int[] pickups) {
        for (int i = lastPickUpPos; i > -1; i--) {
            if (pickups[i] > 0) {
                return i;
            }
        }
        return -1;
    }
}