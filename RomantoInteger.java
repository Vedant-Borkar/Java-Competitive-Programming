import java.util.Scanner;
class RomantoInteger {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int len=s.length();
        char[] ch=new char[len];
        int[] arr=new int[len];
        int i,sum=0;
        for(i=0;i<len;i++)
        {
            char chr=s.charAt(i);
            ch[i]=chr;
        }
        for(i=0;i<len;i++) {
            if(ch[i]=='M')
                arr[i]=1000;
            else if(ch[i]=='D')
                arr[i]=500;
            else if(ch[i]=='C')
                arr[i]=100;
            else if(ch[i]=='L')
                arr[i]=50;
            else if(ch[i]=='X')
                arr[i]=10;
            else if(ch[i]=='V')
                arr[i]=5;
            else if(ch[i]=='I')
                arr[i]=1;
        }
        for(i=0;i<len;i++) {
            if ((i + 1) < len) {
                if (arr[i + 1] > arr[i]) {
                    sum+=arr[i+1]-arr[i];
                    i=i+1;
                }
                else{
                    sum+=arr[i];
                }
            }
            else
                sum+=arr[i];
        }
        System.out.println(sum);

    }
}