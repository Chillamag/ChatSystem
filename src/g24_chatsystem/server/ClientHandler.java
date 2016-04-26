/*
 *  Chat System
 *  Lavet af Gruppe 24 - DTU 2016
 *  --------------------
 *  Bao Duy Nguyen, s144880
 *  Magnus Andrias Nielsen, s141899
 *  --------------------
 */
package g24_chatsystem.server;

import static g24_chatsystem.client.ClientFrame.txtChat;
import static g24_chatsystem.server.ServerFrame.clientOutputStreams;
//import static g24_chatsystem.server.ServerFrame.serverTxtChat;
import static g24_chatsystem.server.ServerFrame.serverTxtChat2;
import static g24_chatsystem.server.ServerFrame.tellEveryone;
import static g24_chatsystem.server.ServerFrame.userAdd;
import static g24_chatsystem.server.ServerFrame.userRemove;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Magnus A. Nielsen
 */
public class ClientHandler implements Runnable	
   {
       BufferedReader reader;
       Socket sock;
       PrintWriter client;

       public ClientHandler(Socket clientSocket, PrintWriter user) 
       {
            client = user;
            try 
            {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            }
            catch (Exception ex) 
            {
                //serverTxtChat.append("Unexpected error... \n");
                serverTxtChat2.append("Unexpected error... \n");
            }

       }

       @Override
       public void run() 
       {
            String message, connect = "Connect", disconnect = "Disconnect", chat = "Chat" ;
            String[] data;

            try 
            {
                while ((message = reader.readLine()) != null) 
                {
                    //serverTxtChat.append("Received: " + message + "\n");
                    data = message.split(":");
                    
                    for (String token:data) 
                    {
                        //serverTxtChat.append(token + "\n");
                    }

                    if (data[2].equals(connect)) 
                    {
                        //tellEveryone((data[0] + ":" + data[1] + ":" + chat));
                        tellEveryone((data[0] + ":" + data[1] + ":" + chat));
                        //txtChat.append("What_What\n");
                        userAdd(data[0]);
                    } 
                    else if (data[2].equals(disconnect)) 
                    {
                        tellEveryone((data[0] + ":has disconnected." + ":" + chat));
                        userRemove(data[0]);
                    } 
                    else if (data[2].equals(chat)) 
                    {
                        tellEveryone(message);
                    } 
                    else 
                    {
                        //serverTxtChat.append("No Conditions were met. \n");
                        serverTxtChat2.append("No Conditions were met. \n");
                    }
                } 
             } 
             catch (Exception ex) 
             {
                //serverTxtChat.append("Lost a connection. \n");
                //serverTxtChat.append(data[2]);
                //System.out.println(data[2]);
                //ex.printStackTrace();
                clientOutputStreams.remove(client);
             } 
	} 
    }
