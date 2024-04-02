package PUSH;
import java.util.*;
class JagjeetBitwise_v1
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        long l,r,x;
        l=sc.nextLong();
        r=sc.nextLong();
        x=l;
        for(long i=l+1;i<=r;i++)
        {
            x=x^i;
        }
        if(x%2==0)
        System.out.println("even");
        else
        System.out.println("odd");

    }
}