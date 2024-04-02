package PUSH;
import java.util.*;
public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.next();
        int len=str.length();int i,j=0,m;
        if(len%2==0) m=len/2;
        else m=len/2+1;
        int[] arr=new int[m];
        for(i=0,j=0;i<len;i++)
        {   char ch=str.charAt(i);
            if(Character.isDigit(ch)) {
                arr[j] =ch-48;
                j++;
            }
        }
        Arrays.sort(arr);
        for(i=0,m=0;i<j;i++,m++)
        {
            System.out.print(arr[i]);
            if(m<j-1)System.out.print("+");
        }
    }
}