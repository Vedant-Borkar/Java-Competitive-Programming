/**
 * Author: Vedant_Borkar
 * Problem:https://docs.google.com/document/d/1GkgHtJLRbkZP2UIKqLPjIFRCLGRu-tcq6HaL2yaYqnc/edit
 * Name: Formula 1
 */
import java.util.*;
public class DhrumilProb{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t=sc.nextInt();
    while(t-->0){
      int n=sc.nextInt();
      int m=sc.nextInt();
      HashMap<String,Integer> map=new HashMap<>(n);//Driver names hashmap
      String[] drivers=new String[n];//Driver names array
      long pts[] = new long[n];//Store Driver points after each race
      int ind=0;//Store driver index in the hashmap
      for(int i=0;i<m;i++){
        PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]) != 0 ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));//To get top 3 of each race
        for(int j=0;j<n;j++){
          String name=sc.next();
          if(!map.containsKey(name)) {//Add names of drivers to the hashmap
            map.put(name,ind++);//Store their index in the integer part of the hashmap
            drivers[j]=name;//Array of their names to store order of the names
          }
          int time=sc.nextInt();
          int penalty=sc.nextInt();
          int index = map.get(name);
				  queue.add(new long[] {time + penalty, j, index});
        }
        for(int j=0;j<3;j++) {//Give points for each race win
          long data[] = queue.poll();
          int driver = (int)data[2];
          if(j == 0) pts[driver] += 25;
          if(j == 1) pts[driver] += 18;
          if(j == 2) pts[driver] += 15;
        }
      }
      long maxPoints = -1;//To search for racer with max points after end of all races
      int maxind=-1;
      for(int i=0;i<n;i++){
        if(pts[i]>maxPoints){ maxind=i; maxPoints=pts[i];}//Find the winner
      }
      System.out.println(pts[maxind] + " " + drivers[maxind]);//Final output
  }
}
}
