import java.util.Scanner;
public class WordoniaWizard
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        int[] s1freq=new int[26];//since all will be set to zero
        int[] s2freq=new int[26];
        int totalpots=0,l1=s1.length(),l2=s2.length();
        int i;
        for(i=0;i<l1;i++)
        {
            char ch=s1.charAt(i);
            if(Character.isUpperCase(ch))
                s1freq[ch-'A']++;
        }
        for(i=0;i<l2;i++)
        {
            char ch=s2.charAt(i);
            if(Character.isUpperCase(ch))
                s2freq[ch-'A']++;
        }

        for(i=0;i<26;i++) {
            int t1 = s1freq[i];
            int t2 = s2freq[i];

            if(l1>l2) {
                if (t1>0 && t2>=0) {
                    totalpots += Math.abs(t1 - t2);
                }
            }
            if(l2>l1) {
                if (t2>0 && t1>=0) {
                    totalpots += Math.abs(t1 - t2);
                }
            }
            if(l1==l2){
                if(t1>t2)
                    totalpots+=Math.abs(t1-t2);
            }

        }
        System.out.println(totalpots);
    }
}