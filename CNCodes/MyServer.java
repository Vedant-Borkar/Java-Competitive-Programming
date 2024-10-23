package CNCodes;
import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) {
        try{
            ServerSocket ss=new ServerSocket(6969);
            System.out.println("Server is running...waiting for client to connect");
            Socket s=ss.accept();

            DataInputStream dis=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());

            String clientmsg="";
            while(!clientmsg.contains( "bye")){
                clientmsg=dis.readUTF();
                System.out.println("Client Message Received: "+ clientmsg);
                if(!clientmsg.contains("bye")){
                    String res="";
                    res=calcRes(clientmsg);
                    System.out.println("Result is= "+ res);
                    dout.writeUTF(res);
                    dout.flush();
                }
            }
        }catch(Exception e){
            System.out.println("Error is : " +e);
        }
    }
    public static String calcRes(String clientmsg) {
        try{
            String[] exp=clientmsg.split(" ");
            if(exp.length!=3){
                return "Incorrect Arithmetic Expression";
            }
            int a=Integer.parseInt(exp[0]);
            int b=Integer.parseInt(exp[2]);
            double ans;
            switch (exp[1]) {
                case "+" -> ans = (a + b);
                case "-" -> ans = (a - b);
                case "*" -> ans = (a * b);
                case "/" -> {
                    if (b == 0) return "Dividing by Zero";
                    ans = (double)(a / b);
                }
                default -> {
                    return "Invalid Operator";
                }
            }
            return String.valueOf(ans);
        }catch(Exception e){
            System.out.println("Error is: "+ e);
            return "Incorrect Arithmetic Expression" + e.getMessage();
        }
    }
}
