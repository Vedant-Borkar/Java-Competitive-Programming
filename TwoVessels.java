import java.util.*;
public class TwoVessels
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int a= sc.nextInt();
            int b= sc.nextInt();
            int c= sc.nextInt();
            int max=Math.max(a,b);
            int min=Math.min(a,b);
            int result=0;
            result=result+(max-min)/(2*c);
            if((max-min)%(2*c)==0)
                System.out.println(result);
            else{
                System.out.println(result+1);
            }
        }
    }
}
