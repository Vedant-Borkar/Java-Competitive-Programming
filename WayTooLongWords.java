import java.util.*;
public class WayTooLongWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, count = 0;
        int t= sc.nextInt();
        while(t-->0) {
            String str = sc.next();
            if (str.length() > 10) {
                String nstr="";
                nstr=nstr+ str.charAt(0) + (str.length()-2) + str.charAt(str.length()-1);
                System.out.println(nstr);
            } else {
                System.out.println(str);
            }
        }
    }
}