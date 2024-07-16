import java.util.Scanner;
class Kristinaburles
{
    public static void main(String[] a)
    {
        Scanner sc=new Scanner(System.in);
        int t= sc.nextInt();
        int i,n,k;String s;
        for(i=0;i<t;i++)
        {
            n = sc.nextInt();
            k = sc.nextInt();
            s = sc.next();
            int result=Burles(n,k,s);
            System.out.println(result);
        }
    }
    public static int Burles(int n, int k, String s)
    {
        int[] lowerfreq=new int[26];//since all will be set to zero
        int[] upperfreq=new int[26];
        int burles=0;int add=0;
        for(int i=0; i<n; i++)
        {
            char ch=s.charAt(i);
            if(Character.isLowerCase(ch))
                lowerfreq[ch-'a']++;//the index of the character gets incremented
            if(Character.isUpperCase(ch))
                upperfreq[ch-'A']++;//the index of the character gets incremented
        }
        //NOW CHECKING DIRECT PAIRS FIRST
        for(int i=0; i<26; i++)
        {
            //now if we check at i=4 meaning at e and E if there are 4 small e and 3 big E then
            // pairs possible is 3 soo use math.Min
            if(lowerfreq[i]>0 || upperfreq[i]>0) {
                int p = Math.min(lowerfreq[i], upperfreq[i]);
                burles = burles + p;
                //add = add + Math.abs(lowerfreq[i] - upperfreq[i]);
                upperfreq[i]=Math.abs(upperfreq[i]-lowerfreq[i]);
                add+=(upperfreq[i]/2);
            }
        }
        burles=burles + Math.min(k,add);
        return burles;
        //now we got the TOTAL BURLES SHE CAN EARN from pairs
        //Since pairs have been formed like 3 pairs=6 characters from n characters are gone
        //now we check remaining characters = n- burles

        //int addburles=Math.min(k,addn);
        //System.out.println(burles);
        //return (burles+addburles);
        /**int remainingPairs = n - (2 * burles);
        int addburles = Math.min(remainingPairs, k);

        return burles + addburles;**/

    }
}