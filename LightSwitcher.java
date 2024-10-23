/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/1993/problem/C
 * Name:CodeChef.S157.C. Light Switches
 */
import java.util.*;
import java.io.*;
public class LightSwitcher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            System.out.println(solve(n, k, a));
        }
    }

    private static int solve(int n, int k, int[] a) {
        boolean[] isOn = new boolean[n];
        int onCount = 0;
        int ctime = 0;

        while (true) {
            ctime++;
            
            for (int i = 0; i < n; i++) {
                if (ctime >= a[i]) {
                    int sinceinstall = ctime - a[i];
                    boolean shldbeon = (sinceinstall / k) % 2 == 0;
                    
                    if (shldbeon != isOn[i]) {
                        isOn[i] = shldbeon;
                        onCount += shldbeon ? 1 : -1;
                    }
                }
            }

            if (onCount == n) {
                return ctime;
            }

            if (ctime > 2 * k * 1000000) {
                return -1;
            }
        }
    }
}