import java.util.Scanner;
public class Team{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t= sc.nextInt();int count=0;
        while(t-->0){
            int ans=0;
            for(int i=0;i<3;i++)
               ans+=sc.nextInt();
            if(ans>=2) count++;
        }
        System.out.println(count);
    }
}