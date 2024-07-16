import java.util.*;
public class MobileTextWrap1
{
    public static List<String> formatText(String s, int lwidth)
    {
        String[] words= s.split(" ");
        List<String> l=new ArrayList<>();
        StringBuilder currentl = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int wordlen = word.length();

            if (currentl.length() == 0) {
                currentl.append(word);
            } else {
                // Calculate the total line length including spaces
                int llen = currentl.length() + wordlen + 1; // Adding 1 for the space

                if (llen <= lwidth) {
                    currentl.append(" ").append(word);
                } else {
                    l.add(currentl.toString());
                    currentl = new StringBuilder(word);
                }
            }
        }

        if (currentl.length() > 0) {
            l.add(currentl.toString());
        }

        return l;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int lwidth= sc.nextInt();
        List<String> formattedLines=formatText(s, lwidth);
        for (int i = 0; i < formattedLines.size(); i++) {
            System.out.println(formattedLines.get(i));
        }
    }
}
