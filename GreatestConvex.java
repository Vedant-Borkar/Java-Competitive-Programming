package PUSH;
import java.util.*;
public class GreatestConvex
{
    public  static void main(String[] args)
    {
        GreatestConvex g=new GreatestConvex();
        Scanner sc=new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0)
        {
            long k=sc.nextLong();
            int i;
            long n,max=0,sum;
            for(i=1;i<k;i++)
            {
                n=i;
                sum= g.Fact(n)+g.Fact(n-1);
                if(sum%k==0)
                {
                    if(n>max)
                        max=n;
                }
            }
            System.out.println(max);
        }
    }
    public int Fact(long n)
    {
        int fact=1;
        for(int i=1;i<=n;i++)
            fact =fact*i;
        if(n==0 || n==1)
            return 1;
        else
            return fact;
    }
}