package PUSH;
import java.util.*;
class JagjeetBitwise_alternate
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        long l,r,x;
        l=sc.nextLong();
        r=sc.nextLong();
        x=r-l;

        if(x%2==0)
            System.out.println("even");
        else
            System.out.println("odd");

    }
}