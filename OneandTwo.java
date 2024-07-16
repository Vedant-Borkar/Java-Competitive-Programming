import java.util.*;
public class OneandTwo
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            int k=-1,m=0,i;
            for(i=0;i<n;i++)
                arr[i]= sc.nextInt();
            for(i=0;i<n;i++)
            {
               if(Prod(0,m,arr)==Prod(m+1,n-1,arr)){
                k=m;break;
               }
               m=m+1;
            }
            if(k!=-1)
            System.out.println(k+1);
            else System.out.println(k);
        }
    }
    public static int Prod(int x,int y,int arr[])
    {
        int prod=1;
        for(int i=x;i<=y;i++)
           prod=prod*arr[i];

        return prod;
    }
}