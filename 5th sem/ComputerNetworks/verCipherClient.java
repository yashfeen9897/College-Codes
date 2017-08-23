import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class verCipherClient {

   public static String encryptor(String message,String key){
            StringBuilder stringBuilder=new StringBuilder();
            message=message.toUpperCase();
            key=key.toUpperCase();
            if(message.length()!=key.length())
            return null;
            for (int i = 0; i <message.length() ; i++) {
                 int value=(message.charAt(i)-65)+(key.charAt(i)-65);
                 value%=26;
                 stringBuilder.append((char)(value+65));
        }

        return stringBuilder.toString();
    }

    public static void main(String args[]){
        int port=8085;
        try {
            Scanner scn=new Scanner(System.in);
            Socket socket=new Socket("127.0.0.1",port);
            System.out.println("BaseClient Connected to "+socket.getRemoteSocketAddress());
            String key="",clientText="";

            InputStream ios= socket.getInputStream();

            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            while(true){
                System.out.println("Put your Text");
                clientText=scn.nextLine();
                System.out.println("ENTER KEY");
                key=scn.nextLine();
                String encryptedMessage=encryptor(clientText,key);
                dataOutputStream.writeUTF(encryptedMessage);
                System.out.println("Encrypted Message "+encryptedMessage);

            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}