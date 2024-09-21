/**
 * Author: Vedant_Borkar
 * Problem:
 * Name: 136. Single Number
 */
import java.util.*;
import java.io.*;
public class SingleNumberLC{
    // VEDANT_BORKAR's TEMPLATE:
    static long inf = (long) (1e18);
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader sc=new FastReader();
    static final Random random=new Random();
    static long mod=1000000007L;
    static HashMap<String,Integer>Stringmap=new HashMap<>();
    static HashMap<Integer,Integer>map=new HashMap<>();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> list=new ArrayList<Integer>();
    static ArrayList<Long> longlist=new ArrayList<>();
    static String ins() {while (st == null || !st.hasMoreElements()) {try {st = new StringTokenizer(br.readLine());} catch (IOException e) {e.printStackTrace();}}return st.nextToken();}
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> pqmax = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Long> pqlong = new PriorityQueue<>();
    //INPUT FUNCTIONS
    //Input string and gives out char array
    static char[] chararr() {return ins().toCharArray();}
    static int ini() {return Integer.parseInt(ins());}
    static long in() {return Long.parseLong(ins());}
    static double ind() {return Double.parseDouble(ins());}
    static String insn() {String str = "";try {if (st.hasMoreTokens()) {str = st.nextToken("\n");} else {str = br.readLine();}} catch (IOException e) {e.printStackTrace();}return str;}
    // Math functions
    public static int max(int a, int b) {return a < b ? b : a;}
    public static long max(long a, long b) {return a > b ? a : b;}
    public static long min(long a, long b) {return a > b ? b : a;}
    public static long ceil(long a, long b) {return ((long) Math.ceil(((double) (a) / b)));}
    public static long abs(long a) {return a < 0 ? (-1 * a) : a;}
    public static long log(long a) {return (long) (Math.log(a));}
    //Math INTEGER FUNCITONS
    public static int gcd(int a, int b) {return b == 0 ? a : gcd(b, a % b);}
    public static int lcm(int a, int b) {return (a / gcd(a, b)) * b;}
    public static int abs(int a) {return a < 0 ? -1 * a : a;}
    //Log base 2
    public static long log2(long a) {return (long) (Math.log(a) / Math.log(2));}
    // lcm and gcd bhi nikal jao khud se ;)
    public static long gcd(long a, long b) {return b == 0 ? a : gcd(b, a % b);}
    public static long lcm(long a, long b) {return ((a * b) / gcd(a, b));}
    // modular arithmetic. Wrong answer nahi aayega ab ;)
    public static long add(long a, long b) {return (((a + mod) % mod + (b + mod) % mod) % mod);}
    public static long sub(long a, long b) {return (((a + mod) % mod + ((-1 * b) + mod) % mod) % mod);}
    public static long mul(long a, long b) {return ((a % mod * b % mod) % mod);}
    public static long inv(long x) {return pow(x, mod - 2);}
    public static long div(long x, long y) {return mul(x, inv(y));}
    // Precise Integer square root
    // Math.sqrt doesnt work precisely for big numbers :(
    public static int sqrt(int x) {int start = 0, end = (int) 1e5, ans = 1;while (start <= end) {int mid = (start + end) / 2;if ((long)mid * mid <= x) {ans = mid;start = mid + 1;} else end = mid - 1;}return ans;}
    public static long sqrt(long x) {long start = 0, end = (long) 3e9, ans = 1;while (start <= end) {long mid = (start + end) / 2;if (mid * mid <= x) {ans = mid;start = mid + 1;} else end = mid - 1;}return ans;}
    // POWER CALCULATION IN SHORTER TIME
    public static long pow(long a, long b) {a %= mod;long res = 1;while (b > 0) {if ((b & 1) != 0) res = mul(res, a);a = mul(a, a);b /= 2;}return res;}
    // FACTORIAL calculation
    public static long Fact(long n) {long fact = 1;if (n == 0 || n == 1) {} else {for (long i = 1; i <= n; i++) fact = fact * i;}return fact;}
    public static int Fact(int n) {int fact = 1;if (n == 0 || n == 1) {} else {for (int i = 1; i <= n; i++) fact = fact * i;}return fact;}
    // O(root n) Prime CHECK calculation
    public static boolean prime(long n) {for (long i = 2; i <= sqrt(n); i++) {if (n % i == 0) {return false;}}return true;}
    //RUFFLE SORT 1-D INTEGER ARRAY
    static void ruffleSort(int[] a) {int n = a.length;for (int i = 0; i < n; i++) {int oi = random.nextInt(n), temp = a[oi];a[oi] = a[i];a[i] = temp;}Arrays.sort(a);}
    // Sort 1-D LONG type array
    public static void sort(long a[]) {divide(a, 0, a.length - 1);}

    public static void divide(long a[], int l, int r) {if (l < r) {int m = l + (r - l) / 2;divide(a, l, m);divide(a, m + 1, r);merge(a, l, m, r);}}

    public static void merge(long a[], int l, int m, int r) {int n1 = m - l + 1;int n2 = r - m;long L[] = new long[n1];long R[] = new long[n2];for (int i = 0; i < n1; ++i) {L[i] = a[l + i];}for (int j = 0; j < n2; ++j) {R[j] = a[m + 1 + j];}int i = 0, j = 0;int k = l;while (i < n1 && j < n2) {if (L[i] <= R[j]) {a[k] = L[i];i++;} else {a[k] = R[j];j++;}k++;}while (i < n1) {a[k] = L[i];i++;k++;}while (j < n2) {a[k] = R[j];j++;k++;}}
    // Sort 1-D LONG type array in descending order
    public static void rsort(long a[]) {rdivide(a, 0, a.length - 1);}
    public static void rdivide(long a[], int l, int r) {if (l < r) {int m = l + (r - l) / 2;rdivide(a, l, m);rdivide(a, m + 1, r);rmerge(a, l, m, r);}}
    public static void rmerge(long a[], int l, int m, int r) {int n1 = m - l + 1;int n2 = r - m;long L[] = new long[n1];long R[] = new long[n2];for (int i = 0; i < n1; ++i) {L[i] = a[l + i];}for (int j = 0; j < n2; ++j) {R[j] = a[m + 1 + j];}int i = 0, j = 0;int k = l;while (i < n1 && j < n2) {if (L[i] >= R[j]) {a[k] = L[i];i++;} else {a[k] = R[j];j++;}k++;}while (i < n1) {a[k] = L[i];i++;k++;}while (j < n2) {a[k] = R[j];j++;k++;}}
    //PRINT ANYTHING FUNCTION
    static < E > void print(E res) {System.out.println(res);}
    // Finding sum  and product of LONG TYPEarray elements
    public static long sum(long a[]) {long s = 0;for (int i = 0; i < a.length; i++) {s = (s + a[i]);}return s;}
    public static long mul(long a[]) {long s = 1;for (int i = 0; i < a.length; i++) {s = (s * a[i]);}return s;}
    // Finding sum  and product of INT TYPEarray elements
    public static int sum(int a[]) {int s = 0;for (int i = 0; i < a.length; i++) {s = (s + a[i]);}return s;}
    public static int mul(int a[]) {int s = 1;for (int i = 0; i < a.length; i++) {s = (s * a[i]);}return s;}
    // MAX IN ARRAY
    public static int max(long a[]) {int in = 0;long m = a[0];for (int i = 1; i < a.length; i++) {if (a[i] > m) {m = a[i];in = i;}}return in;}
    // MIN IN ARRAY
    public static int min(long a[]) {int in = 0;long m = a[0];for (int i = 1; i < a.length; i++) {if (a[i] < m) {m = a[i];in = i;}}return in;}
    // ARRAY PRINTING
    public static void arrprint(long a[]) {for (int i = 0; i < a.length; i++) {System.out.print(a[i] + " ");}System.out.println();}
    public static void arrprint(double a[]) {for (int i = 0; i < a.length; i++) {System.out.print(a[i] + " ");}System.out.println();}
    public static void arrprint(int a[]) {for (int i = 0; i < a.length; i++) {System.out.print(a[i] + " ");}System.out.println();}
    public static void arrprint(char a[]) {for (int i = 0; i < a.length; i++) {System.out.print(a[i]);}System.out.println();}
    //REVERSE ARRAY PRINTING
    public static void revarrprint(long a[]) {for (int i = a.length - 1; i >= 0; i--) {System.out.print(a[i] + " ");}System.out.println();}
    public static void revarrprint(int a[]) {for (int i = a.length - 1; i >= 0; i--) {System.out.print(a[i] + " ");}System.out.println();}
    public static void revarrprint(double a[]) {for (int i = a.length - 1; i >= 0; i--) {System.out.print(a[i] + " ");}System.out.println();}
    //STRING MANIPULATION
    //Reverse a char array
    public static String rev(char s[]) {int n = s.length;for (int i = 0; i < n / 2; i++) {char temp = s[i];s[i] = s[n - 1 - i];s[n - 1 - i] = temp;}return new String(s);}
    //Reverse a String with spaces using StringBuilder
    public static String rev(String s) {return new StringBuilder(s).reverse().toString();}
    //reversing individual words in a space seperated string using builder
    public static String indirev(String s) {String[] words = s.split("\\s+");StringBuilder reversed = new StringBuilder();for (String word : words) {StringBuilder reversedWord = new StringBuilder(word);reversedWord.reverse();reversed.append(reversedWord).append(" ");}return reversed.toString().trim();}

    //FAST READER
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {br = new BufferedReader(new InputStreamReader(System.in));}
        String next() {while (st == null || !st.hasMoreElements()) {try {st = new StringTokenizer(br.readLine());} catch (IOException e) {e.printStackTrace();}}return st.nextToken();}
        int nextInt() {return Integer.parseInt(next());}
        long nextLong() {return Long.parseLong(next());}
        double nextDouble() {return Double.parseDouble(next());}
        String nextLine() {String str = "";try {str = br.readLine();} catch (IOException e) {e.printStackTrace();}return str;}
        //INPUT INT ARRAY
        int[] readintarray(int n) {int res[] = new int[n];for (int i = 0; i < n; i++) res[i] = nextInt();return res;}
        //INPUT INT ARRAYLIST
        ArrayList<Integer> readlist(int n) {ArrayList<Integer> list = new ArrayList<>();for (int i = 0; i < n; i++) {int a = nextInt();list.add(a);}return list;}
        //INPUT LONG ARRAY
        long[] readlongarray(int n) {long res[] = new long[n];for (int i = 0; i < n; i++) res[i] = nextLong();return res;}
        //INPUT STRING return char array
        char[] readchararray() {String str = sc.nextLine();return str.toCharArray();}
    }
    //Here's what u want :)
    public static void main(String args[]) throws IOException {
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> list=new ArrayList<>();
        //Stringmap map pq pqmax pqlong list longlist are defined above
        int t=sc.nextInt();
        //int t=1;
        while(t-->0){
            //HashMap O(N) O(N) approach
            int n= sc.nextInt();
            int[] arr= sc.readintarray(n);
            for(int num : arr) map.put(num,map.getOrDefault(num,0)+1);
            for(int i : map.keySet()){
                if(map.get(i)==1) {
                    res.append(i);break;
                }
            }
            res.append("\n");
            //SINGLE NUMBER FINDING USING XOR APPROACH O(N) O(1) approach
            int xorr=0;
            for(int i : arr) xorr=xorr^i;
            res.append(xorr);
            res.append("\n");
        }
        print(res);
    }
}