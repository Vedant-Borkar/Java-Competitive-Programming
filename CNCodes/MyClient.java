package CNCodes;
import java.io.*;
import java.net.*;

public class MyClient {
    public static void main(String[] args) {
        //Socket
        try {
            Socket s = new Socket("localhost", 6969);
            //inputstream
            DataInputStream dis = new DataInputStream(s.getInputStream());
            //outputstream
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            //BR
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            String clientmsg="",servermsg="";
            while(!clientmsg.contains("bye")){
                System.out.println("Enter arithmetic expression, bye to exit");
                clientmsg= br.readLine();
                dout.writeUTF(clientmsg);
                dout.flush();

                if(!clientmsg.contains("bye")){
                    servermsg=dis.readUTF();
                    System.out.println("Result = "+servermsg);
                }
            }
            s.close();
            dis.close();
            dout.close();

        }catch (Exception e){
            System.out.println("Error is: "+e);
        }
    }
}
