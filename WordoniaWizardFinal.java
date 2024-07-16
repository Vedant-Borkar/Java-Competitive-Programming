import java.util.Scanner;
public class WordoniaWizardFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int[][] minMoves=new int[5005][5005];
        for(int i=0;i<s2.length()+1;i++) {
            minMoves[0][i] = i;
        }
        for(int i=0;i<s1.length()+1;i++) {
            minMoves[i][0] = i;
        }
        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;i<s2.length()+1;j++){
                minMoves[i][j]=Integer.MAX_VALUE;

            }
        }

    }
}