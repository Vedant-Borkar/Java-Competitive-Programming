import java.util.*;
public class BinaryCons {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    String res="";
    while(n!=0){
      if(n%2==1) res='1'+res;
      else res='0'+res;
      n/=2;
    }
    System.out.println(res);
    String str=sc.next();
    Bin2Dec(str);
  }
  static void Bin2Dec(String str){
    int n=0,p=1;
    char[] arr=str.toCharArray();
    for(int i=str.length()-1;i>=0;i--){
      if(arr[i]=='1') n+=p;
      p*=2;
    }
    System.out.println(n);
  }
}
