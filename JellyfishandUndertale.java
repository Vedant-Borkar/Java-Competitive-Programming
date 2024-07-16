import java.util.*;
public class JellyfishandUndertale {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t= sc.nextInt();int i;
        while(t-->0)
        {
            long a= sc.nextLong();
            long b= sc.nextLong();
            int n= sc.nextInt();
            long ans=b;
            for(i=0;i<n;i++) {
                long x=sc.nextLong();
                ans += Math.min(x, a - 1);
            }
            System.out.println(ans);
        }
    }
}