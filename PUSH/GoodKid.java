package PUSH;
import java.util.*;
public class GoodKid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
                arr[i]= sc.nextInt();
            int min=arr[0],prod=1,posn=0;
            for(int i=0;i<n;i++)
            {
                if(min>arr[i]) {
                    min = arr[i];
                    posn=i;
                }
            }
            arr[posn]=arr[posn]+1;
            for(int i=0;i<n;i++)
                prod=prod*arr[i];


            System.out.println(prod);
        }
    }
}