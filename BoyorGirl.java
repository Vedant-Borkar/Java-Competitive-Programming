
import java.util.*;
public class BoyorGirl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();int i, j = 0;
        int[] arr=new int[26];
        for(i=0;i<len;i++){
            char ch=str.charAt(i);
                arr[ch-'a']++;//To get the frequency of alphabets
        }
        for(i=0;i<26;i++){
            if(arr[i]>0)
                j++;
        }
        if(j%2==0)
        System.out.println("CHAT WITH HER!");
        else System.out.println("IGNORE HIM!");
    }
}