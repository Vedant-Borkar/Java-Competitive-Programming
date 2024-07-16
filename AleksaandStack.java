import java.util.*;
public class AleksaandStack{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            for(int i=0;i<n;i++)
                System.out.print(i*2+1+ " ");
            System.out.println();
        }
    }
}
