import java.util.*;
public class PolycarpandDayofPi
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t= sc.nextInt();int i;
        String ans="314159265358979323846264338327";
        char piarr[]=new char[30];
        for(i=0;i<30;i++)
            piarr[i]=ans.charAt(i);
        while(t-->0)
        {
            String str=sc.next();
            int count=0;
            char cmp[]=new char[str.length()];
            for(i=0;i<str.length();i++)
                cmp[i]=str.charAt(i);
            for(i=0;i<str.length();i++)
            {
                if(piarr[i]==cmp[i])
                    count++;
                else break;
            }
            System.out.println(count);
        }
    }
}