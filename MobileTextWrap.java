import java.util.*;
public class MobileTextWrap
{
    public static List<String> formatText(String s, int lwidth)
    {
        String[] words= s.split(" ");
        List<String> l=new ArrayList<>();
        List<String> currentl=new ArrayList<>();

        for(int i=0;i < words.length; i++) {
            String word=words[i];
            if(String.join(" ",currentl).length() + word.length() <= lwidth)
            {
                currentl.add(word);
            }
            else{
                l.add(String.join(" ",currentl));
                currentl.clear();
                currentl.add(word);
            }
        }
        if(!currentl.isEmpty())
        {
            l.add(String.join(" ",currentl));
        }
        return l;
    }
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       String s=sc.nextLine();
       int lwidth= sc.nextInt();

        List<String> finallines=formatText(s,lwidth);
        for(int i=0;i<finallines.size();i++)
        System.out.println(finallines.get(i));
    }

}