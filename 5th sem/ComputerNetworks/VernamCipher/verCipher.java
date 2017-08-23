import java.io.*;
import java.util.Scanner;
import java.net.*;

public class verCipher {

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


    public static void main(String args[]){
        String key,message,encrypedMessage,decryptedMessage;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Message");
        message=scanner.nextLine();
        System.out.println("Enter key");
        key=scanner.nextLine();
        if(key.length()==message.length()){
            encrypedMessage=encryptor(message,key);
            System.out.println("Encrypted Message: "+encrypedMessage);

            decryptedMessage=decryptor(encrypedMessage,key);
            System.out.println("Decrypted Message: "+decryptedMessage);
        }
        else{
            System.out.println("Invalid key");
        }
    }
}