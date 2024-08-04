import java.util.*;
import java.io.*;

public class QuestionMarks{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String answers = br.readLine().trim();
            System.out.println(maxScore(n, answers));
        }
    }
    
    static int maxScore(int n, String answers) {
        Map<Character, Integer> freq = new HashMap<>();
        freq.put('A', 0);
        freq.put('B', 0);
        freq.put('C', 0);
        freq.put('D', 0);
        freq.put('?', 0);
        
        for (char c : answers.toCharArray()) {
            freq.put(c, freq.get(c) + 1);
        }
        
        int maxScore = Math.min(freq.get('A'), n) +
                       Math.min(freq.get('B'), n) +
                       Math.min(freq.get('C'), n) +
                       Math.min(freq.get('D'), n);
        
        return maxScore;
    }
}