//PLEASE DO NOT CHANGE THIS TEMPLATE
import java.util.*;
import java.io.*;
class Translator {
    public static void main(String[] args) {
        //Start coding from here
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        int j=0;
        char arr[]=new char[s1.length()];
        for(int i=s1.length()-1;i>=0;i--)
        {
            arr[j]=s1.charAt(i);
            j++;
        }
        String rev=String.valueOf(arr);
        //System.out.println(rev);
        if(s2.compareTo(rev)==0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}