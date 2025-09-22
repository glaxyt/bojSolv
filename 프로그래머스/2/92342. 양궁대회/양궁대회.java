class Solution {
    static int maxDiff = -1;  // 최대 점수차
    static int[] bestAnswer = new int[11];
    
    public int[] solution(int n, int[] info) {
        // 어피치가 n발을 먼저 쏜다. 어피치의 결과 이후에 라이언이 쏜다.
        // 10 - 0점까지 존재.
        // 누적이 아닌 누가 k점을 가져가는가이다. 따라서 K점을 얻고싶다며 그곳에 많은 화살을 꽂아 넣어야한다.
        // a = b이며 어피치가 가져가기 때문에 라이언은 무조건 그것보다 많이 쏴야한다.
        // 주의: 아무도 맞추지않은 과녁이 있다면 누구도 점수를 가져가지않는다.
        // 어피치의 점수가 나온다. 라이언은 가장 큰 점수차로 이기기 위해서 쏴야한다.
        // 그리디할게 할 수 있는가?
        
        // 요구사항 가장 크게 이기려고 한다면 어떤 구분으로 과녁을 쏴야하는가?가 주안점이다.
        // 가장 큰 점수차를 만드려면, 우선 어피치보다 많이 쏴야한다.
        // 그러나 얻기 쉬운 점수가 있다면 어피치가 못쏜 과녁을 먹어서 점수를 받아도 좋다.
        // 쉽지않다.
        // 10점까지 0점 순서로 맞힌 화살의 개수를 알려준다.
        // 백트래킹 가능 여부 확인
        // 화살의 개수는 10개다. 선택할 수 있는 방법은 2*10 이 최대이다.
        // 그리디 방식으로 잡을 수 있는 방법이 있을까? 
        // 우선 상대보다 높은 점수 중에서 1발로도 먹을 수 있는 점수를 모두 먹는다. 이게 방법 중 하나일듯
        // 그리고 상대의 점수 중에서 내림차순으로 비벼본다. 만일 비빌 수 있다면 걔보다 많이 쏜다.
        // 가장 적은 화살로 어피치보다 많이 쏘는 것을 찾는게 맞는듯.
        // 그리디보다는 백트래킹이 맞는 듯하다.
        // 
        int[] ryan = new int[11];
        dfs(0, n, info, ryan);
        
        return maxDiff == -1 ? new int[]{-1} : bestAnswer;
    }
    
    private static void dfs(int idx, int arrows, int[] info, int[] ryan) {
        if (idx == 11) {
            if (arrows > 0) {
                ryan[10] = arrows;
            }

            calculateAndUpdate(info, ryan);

            ryan[10] = 0;
            return;
        }

        dfs(idx + 1, arrows, info, ryan);

        int needed = info[idx] + 1;
        if (arrows >= needed) {
            ryan[idx] = needed;
            dfs(idx + 1, arrows - needed, info, ryan);
            ryan[idx] = 0;
        }
    }

    private static void calculateAndUpdate(int[] info, int[] ryan) {
        int apeachScore = 0, ryanScore = 0;

        for (int i = 0; i <= 10; i++) {
            if (info[i] > 0 || ryan[i] > 0) {
                if (ryan[i] > info[i]) {
                    ryanScore += (10 - i);
                } else {
                    apeachScore += (10 - i);
                }
            }
        }

        int diff = ryanScore - apeachScore;
        if (diff > 0 && diff > maxDiff) {
            maxDiff = diff;
            bestAnswer = ryan.clone();
        }

        else if (diff > 0 && diff == maxDiff) {
            if (isLowerPriority(ryan, bestAnswer)) {
                bestAnswer = ryan.clone();
            }
        }
    }
    
    private static boolean isLowerPriority(int[] current, int[] best) {
        for (int i = 10; i >= 0; i--) {
            if (current[i] > best[i]) {
                return true;
            }
            else if (current[i] < best[i]) {
                return false;
            }
        }
        return false;
    }  
}
