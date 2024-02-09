import java.util.*;
public class EvenOdds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n=sc.nextLong();
        long k=sc.nextLong();long mid;
        if(n%2==1) mid=n/2+1;
        else mid=n/2;
        if(k>mid) {//For Even
            System.out.println((k-mid)*2);
        }
        else{//For Odd
            System.out.println(2*k-1);
        }
    }
}