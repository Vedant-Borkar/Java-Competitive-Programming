/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/2001/problem/A
 * Name:A. Make All Equal
 */
import java.util.*;
public class MakeAllEqual1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
          int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int maxFrequency = 0;
            int totalFrequency = 0;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int frequency = entry.getValue();
                totalFrequency += frequency;
                if (frequency > maxFrequency) {
                    maxFrequency = frequency;
                }
            }
            int result=0;
            if(totalFrequency>maxFrequency) result = totalFrequency - maxFrequency;
            System.out.println(result);
        }
      }
    }