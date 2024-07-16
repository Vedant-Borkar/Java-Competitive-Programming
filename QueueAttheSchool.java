import java.util.*;
public class QueueAttheSchool
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();int i,temp;
        int t= sc.nextInt();
        String str= sc.next();
        int[] arr=new int[n];
        for(i=0;i<n;i++){
            if(str.charAt(i)=='G')
                arr[i]=0;
            else arr[i]=1;
        }
        while(t>0)
        {
            for(i=0;i<n-1;i++) {
                if (arr[i] == 1 && arr[i + 1] == 0) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    i++;
                }
            }
            t=t-1;
        }
        for(i=0;i<n;i++) {
            if(arr[i]==0) System.out.print('G');
            else System.out.print('B');
        }
    }
}