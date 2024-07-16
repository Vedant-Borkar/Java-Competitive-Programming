import java.util.*;
class SubsetProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m=sc.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[m];
        int i=0,j=0,count=0;
        for(i=0;i<n;i++)
            arr1[i]=sc.nextInt();
        for(i=0;i<m;i++)
            arr2[i]=sc.nextInt();
        for(i=0;i<m;i++)
        {
            int temp=arr2[i];
            for(j=0;j<n;j++)
            {
                if(temp==arr1[j])
                {
                    count++;
                    break;
                }
            }
        }
        if(count==m)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}