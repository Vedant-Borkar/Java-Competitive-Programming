package CNCodes;
import java.util.*;
public class GoBackN {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of Frames");
        int frames= sc.nextInt();
        System.out.println("Enter windown size");
        int window= sc.nextInt();
        System.out.println("Enter frame number to be dropped");
        int m= sc.nextInt();
        gobackn(frames,window,m);
    }
    public static void gobackn(int frame,int window,int m){
        int frames[]=new int[frame];
        int low=0,high=Math.min(frame,window);//window
        int ack=0,received=0;//frames sent and received count;
        int total=0,count=0;
        boolean flag=true;
        for(int i=0;i<frame;i++){
            frames[i]=i;
        }

        System.out.println("First Window to be sent is from " +low +" to"+high);

        while(received<frame){
            //Sending frames
            for (int i = low; i < high && i < frame; i++) {
                System.out.println("Sending frame: "+ frames[i++]);
                total++;
            }

            //Receiving Ack
            while(flag){
                received++;
                count++;
                if(count%m!=0){
                    //Successfully received
                    ack=frames[low];
                    System.out.println("Ack received for frame "+ ack);
                    low++;
                    high++;//slide window ahead
                }else{
                    //Simulate GO BACK N
                    System.out.println("Frame " + frames[low] + " dropped, go back to frame " + frames[low]);
                    received--;
                    flag = false;
                }

                if(low>=frame){
                    //exit
                    System.out.println("ALl frames received");
                    break;
                }
            }
            //Retransmit
            for (int i = low; i < high && i < frame; i++) {
                System.out.println("Retransmitting frame " + frames[i]);
                total++;
            }

            flag = true;
            count = 0;
        }
        System.out.println("All frames sent successfully");
        System.out.println("Total no. of transmissions= "+total);
    }
}
