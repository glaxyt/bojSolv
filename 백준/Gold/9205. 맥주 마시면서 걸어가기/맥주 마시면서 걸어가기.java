import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            
            List<Point> locations = new ArrayList<>();
            
            String[] home = br.readLine().split(" ");
            locations.add(new Point(Integer.parseInt(home[0]), Integer.parseInt(home[1])));
            
            for (int i = 0; i < n; i++) {
                String[] store = br.readLine().split(" ");
                locations.add(new Point(Integer.parseInt(store[0]), Integer.parseInt(store[1])));
            }
            
            String[] festival = br.readLine().split(" ");
            locations.add(new Point(Integer.parseInt(festival[0]), Integer.parseInt(festival[1])));
            
            System.out.println(canReachFestival(locations, n) ? "happy" : "sad");
        }
    }
    
    static boolean canReachFestival(List<Point> locations, int n) {
        int totalLocations = locations.size();
        boolean[] visited = new boolean[totalLocations];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            Point currentPoint = locations.get(current);
            
            Point festival = locations.get(totalLocations - 1);
            if (getManhattanDistance(currentPoint, festival) <= 1000) {
                return true;
            }
            
            for (int i = 1; i < totalLocations - 1; i++) {
                if (!visited[i]) {
                    Point store = locations.get(i);
                    if (getManhattanDistance(currentPoint, store) <= 1000) {
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
        }
        
        return false;
    }
    
    static int getManhattanDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
