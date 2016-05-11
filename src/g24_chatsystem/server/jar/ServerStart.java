/*
 *  Chat System
 *  Lavet af Gruppe 24 - DTU 2016
 *  --------------------
 *  Magnus Andrias Nielsen, s141899
 *  --------------------
 */
package g24_chatsystem.server.jar;

import java.util.ArrayList;
import static g24_chatsystem.server.jar.ChatLogic.clientOutputStreams;
import static g24_chatsystem.server.jar.ChatLogic.users;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Magnus A. Nielsen
 */
public class ServerStart implements Runnable {
    
    @Override
    public void run(){
        clientOutputStreams = new ArrayList();
        users = new ArrayList(); 
        
        try{
            ServerSocket serverSock = new ServerSocket(1108);
            
            while(true){
                Socket clientSock = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
                clientOutputStreams.add(writer);
                Thread listener = new Thread(new ClientHandler(clientSock, writer));
                listener.start();
                
            }
            
        }catch (Exception ex){
            System.out.println("Error making a connection. \n");
        }
    }
    
}
