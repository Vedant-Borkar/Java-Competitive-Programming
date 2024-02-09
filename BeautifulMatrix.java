import java.util.*;
public class BeautifulMatrix
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int arr[][]=new int[5][5];
        int i,j,pi=0,pj=0;
        for(i=0;i<5;i++)
        {
            for(j=0;j<5;j++)
            {
                arr[i][j]= sc.nextInt();
                if(arr[i][j]==1)
                {   pi=i;pj=j;}
            }
        }
        System.out.println(Math.abs(2-pi)+Math.abs(2-pj));
    }
}