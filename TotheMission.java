import java.util.*;
class TotheMission {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n= sc.nextInt();
            int m= sc.nextInt();
            int h= sc.nextInt();
            int len=Math.min(n,m);int i,j,temp,maxwatt=0;
            int arrn[]=new int[n];
            int arrm[]=new int[m];
            
            for(i=0;i<n;i++)
                arrn[i]= sc.nextInt();

            for(i=0;i<m;i++)
                arrm[i]= sc.nextInt();
            if(n>1) {
                for (i = 0; i < n; i++) {
                    for (j = 1; j < (n - i); j++) {
                        if (arrn[j - 1] < arrn[j]) {
                            temp = arrn[j - 1];
                            arrn[j - 1] = arrn[j];
                            arrn[j] = temp;
                        }
                    }
                }
            }
            if(m>1) {
                for (i = 0; i < m; i++) {
                    for (j = 1; j < (m - i); j++) {
                        if (arrm[j - 1] < arrm[j]) {
                            temp = arrm[j - 1];
                            arrm[j - 1] = arrm[j];
                            arrm[j] = temp;
                        }
                    }
                }
            }
            for(i=0;i<len;i++)
            {
                maxwatt= maxwatt+ Math.min(arrn[i],h*arrm[i]);
            }
            System.out.println(maxwatt);
        }
    }
}