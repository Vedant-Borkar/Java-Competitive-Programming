import java.util.Scanner;
public class TargetPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, n, i, j = 0, count = 0;
        t = sc.nextInt();
        while (t-- > 0) {
            char[][] arr=new char[10][10];
            for(i=0;i<10;i++)
            {
                for(j=0;j<10;j++)
                {
                    char ch=sc.next().charAt(0);
                    arr[i][j]=ch;
                }
            }
            for(i=0;i<10;i++) {
                for (j = 0; j < 10; j++) {
                    if(arr[i][j]=='X')
                    {
                        
                    }
                }
            }

        }
    }
}