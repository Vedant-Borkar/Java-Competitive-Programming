/**
 * Author: Vedant_Borkar
 * Problem: https://codeforces.com/contest/2004/problem/A
 * Name:A. Closest Point 
 */
import java.io.*;
import java.util.*;

public class ClosestPoint {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){br = new BufferedReader(new InputStreamReader(System.in));}
        String next(){while (st == null || !st.hasMoreElements()) {try {st = new StringTokenizer(br.readLine());}catch (IOException e) {e.printStackTrace();}}return st.nextToken();}
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() {return Double.parseDouble(next());}
    }

    void yes() {out.println("YES");}
    void no() {out.println("NO");}
    void inArr(int[] a){for(int i=0;i<a.length;i++){a[i]=sc.nextInt();}}
    void inArr(long[] a){for(int i=0;i<a.length;i++){a[i]=sc.nextLong();}}
    void inArr(String[] a){for(int i=0;i<a.length;i++){a[i]=sc.next();}}
    void pArr(int[] a){for(int i=0; i<a.length;i++){out.print(a[i]+" ");}}
    void pArr(long[] a){for(int i=0; i<a.length;i++){out.print(a[i]+" ");}}
    void pArr(String[] a){for(int i=0; i<a.length;i++){out.print(a[i]+" ");}}
    void pArr(ArrayList<Integer> a){for(int i=0; i<a.size();i++){out.print(a.get(i)+" ");}}
    //    void pArr(ArrayList<Long> a){for(int i=0; i<a.size();i++){out.print(a.get(i)+" ");}}
    void pl(){out.println();}
    void pl(int x){out.println(x);}
    void pl(long x){out.println(x);}
    void pl(double x){out.println(x);}
    void pl(String x){out.println(x);}
    void pl(char x){out.println(x);}
    int getInt(char ch){return Integer.parseInt(String.valueOf(ch));}
    long max(long a, long b){return Math.max(a, b);}
    long min(long a, long b){return Math.min(a, b);}
    int gcd(int a, int b) {while (b != 0) {int temp = b;b = a % b;a = temp;}return a;}
    public static boolean isSorted(int[] a) {for (int i = 0; i < a.length - 1; i++) {if (a[i] > a[i + 1]) {return false;}}return true;}
    public static void reverseArr(int[] a){int i=0, j=a.length-1;while (i<j){int temp=a[i];a[i]=a[j];a[j]=temp;i++;j--;}}
    public static void reverseArr(long[] a){int i=0, j=a.length-1;while (i<j){long temp=a[i];a[i]=a[j];a[j]=temp;i++;j--;}}
    void sort(long a[]) {divide(a, 0, a.length - 1, true);}
    void rsort(long a[]) {divide(a, 0, a.length - 1, false);}
    void divide(long a[], int l, int r, boolean order) {if (l < r) {int m = l + (r - l) / 2;divide(a, l, m, order);divide(a, m + 1, r, order);merge(a, l, m, r, order);}}
    void merge(long a[], int l, int m, int r, boolean order) {int n1 = m - l + 1;int n2 = r - m;long L[] = new long[n1];long R[] = new long[n2];for (int i = 0; i < n1; ++i) L[i] = a[l + i];for (int j = 0; j < n2; ++j) R[j] = a[m + 1 + j];int i = 0, j = 0; int k = l;while (i < n1 && j < n2) {if ((L[i] <= R[j] && order) || (L[i] >= R[j] && !order)) {a[k] = L[i];i++;} else {a[k] = R[j];j++;}k++;}while (i < n1) {a[k] = L[i];i++;k++;}while (j < n2) {a[k] = R[j];j++;k++;}}
    void sort(long a[][]) {divide(a, 0, a[0].length - 1, true);}
    void rsort(long a[][]) {divide(a, 0, a[0].length - 1, false);}
    void divide(long a[][], int l, int r, boolean order) {if (l < r) {int m = l + (r - l) / 2;divide(a, l, m, order);divide(a, m + 1, r,order);merge(a, l, m, r, order);}}
    void merge(long a[][], int l, int m, int r, boolean order) {int n1 = m - l + 1;int n2 = r - m;long L[] = new long[n1]; long R[] = new long[n2];long b1[][] = new long[a.length][n1]; long b2[][] = new long[a.length][n2];for (int i = 0; i < n1; ++i) {L[i] = a[0][l + i];for (int p = 1; p < a.length; p++) b1[p][i] = a[p][l + i];}for (int j = 0; j < n2; ++j) {R[j] = a[0][m + 1 + j];for (int p = 1; p < a.length; p++) b2[p][j] = a[p][m + 1 + j];}int i = 0, j = 0; int k = l;while (i < n1 && j < n2) {if ((L[i] <= R[j] && order) || (L[i] >= R[j] && !order)) {a[0][k] = L[i]; for (int p = 1; p < a.length; p++) a[p][k] = b1[p][i];i++;} else {a[0][k] = R[j];for (int p = 1; p < a.length; p++) a[p][k] = b2[p][j];j++;}k++;}while (i < n1) {a[0][k] = L[i];for (int p = 1; p < a.length; p++) a[p][k] = b1[p][i];i++;k++;}while (j < n2) {a[0][k] = R[j];for (int p = 1; p < a.length; p++) a[p][k] = b2[p][j];j++;k++;}}


    public static final int MOD = 1000000000 + 7;

    FastReader sc=new FastReader();
    PrintWriter out=new PrintWriter(System.out);

    public static void main(String args[]) {
        ClosestPoint FC27 = new ClosestPoint();
        FC27.solve();
    }

    public static class Pair implements Comparable<Pair>{
        long a;
        long b;
        public Pair(long a, long b){
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Pair p2) {
            if (this.a == p2.a) {
                return Long.compare(this.b, p2.b);
            }
            return Long.compare(this.a, p2.a);
        }
    }
    
    public void ans() {
        int n=sc.nextInt();
        int[] a = new int[n];
        inArr(a);
        if(n==2 && Math.abs(a[0]-a[1])>1) yes();
        else no();
    }

    public void solve() {
        int t = sc.nextInt();
//        int t = 1;
        while(t-- > 0){
            ans();
        }
        out.close();
    }
}