/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/1998/problem/A
 * Name:A. Find K Distinct Points with Fixed Center
 */
import java.util.*;

public class PointGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int xc = sc.nextInt();
            int yc = sc.nextInt();
            int k = sc.nextInt();
            
            List<Point> points = generatePoints(xc, yc, k);
            for (Point p : points) {
                System.out.println(p.x + " " + p.y);
            }
        }
    }
    public static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static List<Point> generatePoints(int xc, int yc, int k) {
        List<Point> points = new ArrayList<>();
        int sumX = 0, sumY = 0;
        for (int i = 0; i < k - 1; i++) {
            int x = xc - (k - 1) + i;
            int y = yc - (k - 1) + i;
            points.add(new Point(x, y));
            sumX += x;
            sumY += y;
        }
        int lastX = k * xc - sumX;
        int lastY = k * yc - sumY;
        points.add(new Point(lastX, lastY));
        
        return points;
    }
}