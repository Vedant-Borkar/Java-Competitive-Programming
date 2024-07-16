import java.util.*;
public class LuckyNumbers {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i;
        while (t-- > 0) {
            int l= sc.nextInt();
            int r= sc.nextInt();int ans=l,lucky,maxluck=0;
            for(i=l;i<=r;i++){
               lucky=Lucky(i);
               if(lucky>=maxluck){
                   maxluck=lucky;
                   ans=i;
                   if(maxluck==9) break;
               }
            }
            System.out.println(ans);
        }
    }
    public static int Lucky(int a){
        int max=a%10;int min=a%10;
        while(a!=0) {
            max=Math.max(a%10,max);
            min=Math.min(a%10,min);
            a = a / 10;
        }
        return max-min;
    }
}