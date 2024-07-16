import java.util.*;
class JagjeetBitwise_v2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        long l,r,x;
        l=sc.nextLong();
        r=sc.nextLong();
        x=l;
        if(r>Math.pow(10,11) && r<Math.pow(10,18))
            System.out.println("odd");
        else if(l>Math.pow(10,11) && l<Math.pow(10,18))
            System.out.println("odd");
        else {
            for (long i = l + 1; i <= r; i++) {
                x = x ^ i;
            }
            if (x % 2 == 0)
                System.out.println("even");
            else
                System.out.println("odd");
        }
    }
}