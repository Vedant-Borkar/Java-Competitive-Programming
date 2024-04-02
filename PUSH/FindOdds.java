package PUSH;
import java.util.*;
class FindOdds
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0)
        {
            int n= sc.nextInt();
            int k=sc.nextInt();
            int s=sc.nextInt();
            int sum=s-n*n;
            System.out.println(sum/(k-1));
        }
    }
}