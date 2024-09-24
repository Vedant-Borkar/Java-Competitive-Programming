import java.util.*;
class ATCGENERATOR1
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n2= sc.nextInt();
        int n=sc.nextInt();
        String[] arr=new String[n];
        for(int i=0;i<n;i++) arr[i]=sc.next();
        clearScreen();
        //FOR OUTPUT
//        String arr1[]=new String[n];
//        for(int i=0;i<n;i++) arr1[i]=sc.next();
        System.out.println(n2);
        for(int i=0;i<(n2/n);i++){
           for(String j:arr){
               System.out.println(j);
           }
        }
        //FOR OUTPUT
//        for(int i=0;i<(n2/n);i++){
//            for(String j:arr1){
//                System.out.println(j);
//            }
//        }

    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
