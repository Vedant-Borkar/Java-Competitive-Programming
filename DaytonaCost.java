import java.util.*;
public class DaytonaCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n= sc.nextInt();
            int k= sc.nextInt();
            int arr[]=new int[n];
            int num[]=new int[101];
            for(int i=0;i<n;i++)
            {
                arr[i]= sc.nextInt();
                int q=arr[i];
                num[q]++;
            }
            int max=num[0],posn=0;
            for(int i=1;i<=100;i++)
            {
                if(max<=num[i]){
                  max=num[i];
                  posn=i;
                }
            }
            if(k==posn)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}