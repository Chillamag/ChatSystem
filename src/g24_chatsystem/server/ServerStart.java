/*
 *  Chat System
 *  Lavet af Gruppe 24 - DTU 2016
 *  --------------------
 *  Bao Duy Nguyen, s144880
 *  Magnus Andrias Nielsen, s141899
 *  --------------------
 */
package g24_chatsystem.server;

import g24_chatsystem.server.jar.ClientHandler;
import static g24_chatsystem.server.ServerFrame.clientOutputStreams;
//import static g24_chatsystem.server.ServerFrame.serverTxtChat;
import static g24_chatsystem.server.ServerFrame.serverTxtChat2;
import static g24_chatsystem.server.ServerFrame.users;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Magnus A. Nielsen
 */
public class ServerStart implements Runnable {
        @Override
        public void run() 
        {
            
            clientOutputStreams = new ArrayList();
            users = new ArrayList();  

            try 
            {
                ServerSocket serverSock = new ServerSocket(2222);

                while (true) 
                {
				Socket clientSock = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
				clientOutputStreams.add(writer);

				Thread listener = new Thread(new ClientHandler(clientSock, writer));
				listener.start();
				//serverTxtChat.append("Got a connection. \n");
                                //serverTxtChat2.append("Got a connection. \n");
                }
            }
            catch (Exception ex)
            {
                //serverTxtChat.append("Error making a connection. \n");
                serverTxtChat2.append("Error making a connection. \n");
            }
        }
    }
