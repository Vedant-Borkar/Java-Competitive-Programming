import java.util.Scanner;
public class WordGame {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t,n,a,b,i,j=0,count=0;
        t= sc.nextInt();
        while(t-->0)
        {
            n= sc.nextInt();
            int arr1[]=new int[n];
            int arr2[]=new int[n];
            for(i=0;i<n;i++)
            {
                a=sc.nextInt();
                b=sc.nextInt();
                arr1[i]=a;
                arr2[i]=b;
            }
            int max=0,posn=0;
            for(i=0;i<n;i++){
               if(arr1[i]<=10)
               {
                   if(arr2[i]>max) {
                       max = arr2[i];posn=i;
                   }
               }
            }
            System.out.println(posn+1);
        }
    }
}
