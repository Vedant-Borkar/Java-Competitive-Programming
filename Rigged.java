import java.util.*;
public class Rigged {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();int i;long w;
        while(t-->0)
        {
            int n=sc.nextInt();
            int sarr[]=new int[n];
            int earr[]=new int[n];
            for(i=0;i<n;i++)
            {
                sarr[i]=sc.nextInt();
                earr[i]= sc.nextInt();
            }
            int check1=sarr[0];
            int maxs=sarr[0],posns=0;
            int maxe=earr[0],posne=0;
            for(i=0;i<n;i++)
            {
               if(maxs<sarr[i])
               {
                   maxs=sarr[i];
                   posns=i;
               }
                if(maxe<earr[i])
                {
                    maxe=earr[i];
                    posne=i;
                }
            }
            if(posns==0 && posne==0)
                System.out.println();
        }
    }
}