import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String comboStr = "";
    static int[] minimumNutrient = new int[4];
    static int minCost = Integer.MAX_VALUE;
    static int[][] ingredients;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] minimumTempNutrient = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < 4; i++) {
            minimumNutrient[i] = minimumTempNutrient[i];
        }

        ingredients = new int[n + 1][5];
        for (int i = 0; i < n; i++) {
            int[] ingredient = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 5; j++) {
                ingredients[i + 1][j] = ingredient[j];
            }
        }

        dfs(n, 1, new NutrientCombo(minimumNutrient[0], minimumNutrient[1], minimumNutrient[2], minimumNutrient[3]));

        if (minCost == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCost);
            System.out.println(comboStr);
        }
    }

    private static void dfs(int n, int start, NutrientCombo combo) {
        if (combo.isSatisfy()) {
            if (minCost > combo.cost) {
                minCost = combo.cost;
                comboStr = combo.printCombo();
            }
        }

        for (int i = start; i <= n; i++) {
            combo.addIngredient(i, ingredients[i]);
            dfs(n, i+1, combo);
            combo.removeIngredient(i, ingredients[i]);
        }
    }
}

class NutrientCombo {
    int lowerProtein;
    int lowerFat;
    int lowerTansoo;
    int lowerVitamin;

    int protein = 0;
    int fat = 0;
    int tansoo = 0;
    int vitamin = 0;
    int cost = 0;
    List<Integer> combo = new ArrayList<>();

    public NutrientCombo(int lowerProtein, int lowerFat, int lowerTansoo, int lowerVitamin) {
        this.lowerProtein = lowerProtein;
        this.lowerFat = lowerFat;
        this.lowerTansoo = lowerTansoo;
        this.lowerVitamin = lowerVitamin;
    }

    public void addIngredient(int idx, int[] ingredient) {
        protein += ingredient[0];
        fat += ingredient[1];
        tansoo += ingredient[2];
        vitamin += ingredient[3];
        cost += ingredient[4];
        combo.add(idx);
    }

    public void removeIngredient(int idx, int[] ingredient) {
        protein -= ingredient[0];
        fat -= ingredient[1];
        tansoo -= ingredient[2];
        vitamin -= ingredient[3];
        cost -= ingredient[4];
        combo.remove(combo.size() - 1);
    }

    public boolean isSatisfy() {
        if (lowerProtein > protein) return false;
        if (lowerFat > fat) return false;
        if (lowerTansoo > tansoo) return false;
        if (lowerVitamin > vitamin) return false;
        return true;
    }

    public String printCombo() {
        StringBuilder sb = new StringBuilder();
        for (Integer i : combo) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
}
