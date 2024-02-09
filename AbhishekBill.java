import java.util.*;
class AbhishekBill{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int count=0;
        while(n>0)
        {
            if(n/100>0)
            {
                while(n/100!=0)
                {
                    count++;
                    n=n-100;
                }
            }
            if(n/20>0)
            {
                while(n/20!=0)
                {
                    count++;
                    n=n-20;
                }
            }
            if(n/10>0)
            {
                while(n/10!=0)
                {
                    count++;
                    n=n-10;
                }
            }
            if(n/5>0)
            {
                while(n/5!=0)
                {
                    count++;
                    n=n-5;
                }
            }
            if(n/1>0)
            {
                while(n/1!=0)
                {
                    count++;
                    n=n-1;
                }
            }
        }
        System.out.println(count);
    }
}