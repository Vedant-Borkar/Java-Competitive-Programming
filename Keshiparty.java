/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/1610/problem/C
 * Name:Keshi Party
 */
import java.util.*;
import java.io.*;
public class Keshiparty{
    // VEDANT_BORKAR's TEMPLATE:
    static long inf = (long) (1e18);
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader sc=new FastReader();
    static final Random random=new Random();
    static long mod=1000000007L;
    static HashMap<String,Integer>map=new HashMap<>();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> list=new ArrayList<Integer>();
    static String ins() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int max(int a, int b)
    {
        if(a<b)
            return b;
        return a;
    }
    //INPUT FUNCTIONS
    //Input string and gives out char array
    static char[] chararr() {return ins().toCharArray();
    }
    static int ini() {
        return Integer.parseInt(ins());
    }

    static long in() {
        return Long.parseLong(ins());
    }

    static double ind() {
        return Double.parseDouble(ins());
    }

    static String insn() {
        String str = "";
        try {
            if (st.hasMoreTokens()) {
                str = st.nextToken("\n");
            } else {
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    // Math functions
    public static long max(long a, long b) {
        return a > b ? a : b;
    }

    public static long min(long a, long b) {
        return a > b ? b : a;
    }

    public static long ceil(long a, long b) {
        return ((long) Math.ceil(((double) (a) / b)));
    }

    public static long abs(long a) {
        if (a < 0) {
            return (-1 * a);
        }
        return a;
    }

    public static long log(long a) {
        return (long) (Math.log(a));
    }

    public static  long log2(long a) {
        return (long) (Math.log(a) / Math.log(2));
    }

    // lcm and gcd bhi nikal jao khud se ;)
    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static  long lcm(long a, long b) {
        return ((a * b) / gcd(a, b));
    }

    // modular arithmetic. Wrong answer nahi aayega ab ;)
    public static long add(long a, long b) {
        return (((a + mod) % mod + (b + mod) % mod) % mod);
    }

    public static  long sub(long a, long b) {
        return (((a + mod) % mod + ((-1 * b) + mod) % mod) % mod);
    }

    public static  long mul(long a, long b) {
        return ((a % mod * b % mod) % mod);
    }

    public static long inv(long x) {
        return pow(x, mod - 2);
    }

    public static  long div(long x, long y) {
        return mul(x, inv(y));
    }
    // Precise Integer square root
    // Math.sqrt doesnt work precisely for big numbers :(
    public static long sqrt(long x) {
        long start = 0, end = (long) 3e9, ans = 1;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (mid * mid <= x) {
                ans = mid;
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return ans;
    }

    // POWER CALCULATION IN SHORTER TIME
    public static long pow(long a, long b) {
        a %= mod;
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0)
                res = mul(res, a);
            a = mul(a, a);
            b /= 2;
        }
        return res;
    }

    // FACTORIAL calculation
    public static long Fact(long n){
        long fact=1;
        if(n==0 || n==1){}
        else{
            for(long i=1;i<=n;i++)
                fact=fact*i;
        }
        return fact;
    }
    public static int Fact(int n){
        int fact=1;
        if(n==0 || n==1){}
        else{
            for(int i=1;i<=n;i++)
                fact=fact*i;
        }
        return fact;
    }

    // O(root n) Prime calculation
    public static  boolean prime(long n) {
        for (long i = 2; i <= sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    //RUFFLE SORT 1-D INTEGER ARRAY
    static void ruffleSort(int[] a) {
        int n=a.length;
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }

    // Sort 1-D LONG type array
    public static void sort(long a[]) {
        divide(a, 0, a.length - 1);
    }

    public static void divide(long a[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            divide(a, l, m);
            divide(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public static void merge(long a[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        long L[] = new long[n1];
        long R[] = new long[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = a[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = a[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    // Sort 1-D LONG type array in descending order
    public static void rsort(long a[]) {
        rdivide(a, 0, a.length - 1);
    }

    public static  void rdivide(long a[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            rdivide(a, l, m);
            rdivide(a, m + 1, r);
            rmerge(a, l, m, r);
        }
    }

    public static void rmerge(long a[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        long L[] = new long[n1];
        long R[] = new long[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = a[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = a[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }
    //PRINT ANYTHING FUNCTION
    static < E > void print(E res)
    {
        System.out.println(res);
    }


    static  int gcd(int a,int b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
    }

    static  int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }


    static  int abs(int a)
    {
        if(a<0)
            return -1*a;
        return a;
    }
    // Finding sum of array elements
    public static long sum(long a[]) {
        long s = 0;
        for (int i = 0; i < a.length; i++) {
            s = (s + a[i]);
        }
        return s;
    }
    // Finding Product of array elements
    public static long mul(long a[]) {
        long s = 1;
        for (int i = 0; i < a.length; i++) {
            s = (s * a[i]);
        }
        return s;
    }

    // MAX IN ARRAY
    public static int max(long a[]) {
        int in = 0;
        long m = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > m) {
                m = a[i];
                in = i;
            }
        }
        return in;
    }
    // MIN IN ARRAY
    public static int min(long a[]) {
        int in = 0;
        long m = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < m) {
                m = a[i];
                in = i;
            }
        }
        return in;
    }

    // ARRAY PRINTING
    public static void arrprint(long a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void arrprint(double a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void arrprint(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void arrprint(char a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }
    //REVERSE ARRAY PRINTING
    public static void revarrprint(long a[]) {
        for (int i = a.length-1; i >=0; i--) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void revarrprint(int a[]) {
        for (int i = a.length-1; i >=0; i--) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void revarrprint(double a[]) {
        for (int i = a.length-1; i >=0; i--) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    //BINARY SEARCH
    static int Binary2D(int mid,int[][] ar,int a){
        int ans = -1; // Initialize ans to -1, indicating not found
        int low = 0;
        int high = ar.length * ar[0].length - 1; // Total number of elements in the 2D array
        while (low <= high) {
            int midValue = ar[mid / ar[0].length][mid % ar[0].length]; // Calculate the value at mid index
            if (midValue == a) {
                ans = mid; // Set ans to mid index if value is found
                break;
            } else if (midValue < a) {
                low = mid + 1; // Update low if value at mid is less than 'a'
            } else {
                high = mid - 1; // Update high if value at mid is greater than 'a'
            }
            mid = (low + high) / 2; // Recalculate mid
        }
        return ans;
    }

    int Binary(int mid, int[] ar, int a) {
        int low = 0;
        int high = ar.length - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (ar[mid] == a)
                return mid;
            else if (ar[mid] < a)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1; // If element is not present in array
    }
    
    //STRING MANIPULATION
    //Reverse a char array
    public static String rev(char s[]) {
        int n=s.length;
        for (int i=0; i<n/2; i++)
        {
            char temp = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = temp;
        }
        return new String(s);
    }
    //Reverse a String with spaces using StringBuilder
    public static String rev(String s){
        //String s= sc.nextLine();
        String reversed=new StringBuilder(s).reverse().toString();
        return reversed;
    }
    //reversing individual words in a space seperated string using builder
    public static String indirev(String s){
        //String s= sc.nextLine();
        String[] words = s.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word);
            reversedWord.reverse();
            reversed.append(reversedWord).append(" ");
        }
        return reversed.toString().trim();
    }

    //FAST READER
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
        //INPUT INT ARRAY
        int [] readintarray(int n) {
            int res [] = new int [n];
            for(int i = 0; i<n; i++)res[i] = nextInt();
            return res;
        }
        //INPUT INT ARRAYLIST
        ArrayList<Integer> readlist(int n){
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                int a=nextInt();
                list.add(a);
            }
            return list;
        }
        //INPUT LONG ARRAY
        long [] readlongarray(int n) {
            long res [] = new long [n];
            for(int i = 0; i<n; i++)res[i] = nextLong();
            return res;
        }
        //INPUT STRING return char array
        char[] readchararray(){
            String str= sc.nextLine();
            return str.toCharArray();
        }
    }
    //Here's what u want :)
    public static boolean f(int mid, int[][] a, int n){
        int cnt = 0;
        for (int i=0; i<n; i++){
            int r=a[i][0], l=a[i][1];
            if (l >= cnt && mid - 1 - cnt <= r){
                cnt++;
            }
        }
        return cnt>=mid;
    }
    public static void main(String args[]) throws IOException {
        StringBuilder res = new StringBuilder();
        int i,j,count=0,n,t;
        ArrayList<Integer> list=new ArrayList<>();
        t=sc.nextInt();
        while(t-->0){
            n = sc.nextInt();
            int[][] a = new int[n][2];
            for (i=0; i<n; i++){
                a[i][0]=sc.nextInt();
                a[i][1]=sc.nextInt();
            }
            int l=0, r=n, ans=0;
            while(l<=r){
                int mid = (l+r)/2;
                if (f(mid,a,n)){
                    ans=mid;
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
            print(ans);     
        }
    }
}