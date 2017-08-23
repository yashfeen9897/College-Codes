import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class verCipherServer {

    public static void main(String args[]){
        int port=8085;
        try {
            Scanner scn=new Scanner(System.in);
            ServerSocket serverSocket=new ServerSocket(port);
            serverSocket.setSoTimeout(100*1000);
            System.out.println("Server Says: Client Connected to Server at port "+serverSocket.getLocalPort());
            Socket socket=serverSocket.accept();
            System.out.println("Server Says: Client Connected "+socket.getLocalAddress());
            String clientText="",key="";
            InputStream ios= socket.getInputStream();
            DataInputStream dataInputStream=new DataInputStream(ios);

            while(true){
                if(ios.available()>0) {
                    clientText = dataInputStream.readUTF();
                    System.out.println("ENTER KEY");
                    key=scn.nextLine();
                    if (!clientText.isEmpty())
                        System.out.println("Client Says: " + decryptor(clientText,key));
                    else
                        System.out.println("Client Text Empty: ");
                }
            }


        } catch (IOException e) {

            e.printStackTrace();
        }
    }
       public static String decryptor(String message,String key){
             StringBuilder stringBuilder=new StringBuilder();
             message=message.toUpperCase();
             key=key.toUpperCase();
             if(message.length()!=key.length())
               return null;
        for (int i = 0; i <message.length() ; i++) {
            int value=(message.charAt(i)-65)-(key.charAt(i)-65);
            int newValue=value%26;
            if(newValue<0)
                newValue+=26;

            stringBuilder.append((char)(newValue+65));
        }

        return stringBuilder.toString();
    }

     
}