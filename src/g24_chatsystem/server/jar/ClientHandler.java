/*
 *  Chat System
 *  Lavet af Gruppe 24 - DTU 2016
 *  --------------------
 *  Magnus Andrias Nielsen, s141899
 *  --------------------
 */
package g24_chatsystem.server.jar;

//import static g24_chatsystem.server.ServerFrame.serverTxtChat;
//import static g24_chatsystem.server.ServerFrame.serverTxtChat2;

import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.Naming;

/**
 *
 * @author Magnus A. Nielsen
 */
public class ClientHandler implements Runnable	
   {
        ChatUser chatUser;
        ChatLogic chatLogic;
       BufferedReader reader;
       Socket sock;
       PrintWriter client;
       static String firstName = "";
       static String lastName = "";

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
                //serverTxtChat2.append("Unexpected error... \n");
                System.out.println("Unexpected error... \\n");
            }

       }

       @Override
       public void run() 
       {
            String message, connect = "Connect", disconnect = "Disconnect", chat = "Chat" , login = "Login";
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
                        chatLogic.tellEveryone((data[0] + ":" + data[1] + ":" + chat));
                        //chatUser.tellEveryone((data[0] + ":" + data[1] + ":" + chat));
                        //txtChat.append("What_What\n");
                        //chatUser.userAdd(data[0]);
                        chatLogic.userAdd(data[0]);
                    } 
                    else if (data[2].equals(disconnect)) 
                    {
                        //chatUser.tellEveryone((data[0] + ":has disconnected." + ":" + chat));
                        //chatUser.userRemove(data[0]);
                        
                        chatLogic.tellEveryone((data[0] + ":has disconnected." + ":" + chat));
                        chatLogic.userRemove(data[0]);
                    } 
                    else if (data[2].equals(chat)) 
                    {
                        //chatUser.tellEveryone(message);
                        chatLogic.tellEveryone(message);
                    } 
                    else if (data[2].equals(login)) 
                    {
                        //chatLogic.tellEveryone(message);
                        
                        Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
                        
                        String usernameInput = data[0];
                        String passwordInput = data[3];
                        
                        try{
                            Bruger b = ba.hentBruger(usernameInput, passwordInput);
                                
                            //System.out.println("\nLogged in as: " + b.fornavn + " " + b.efternavn + ".\n");
                            //loggedIn = true;
                            firstName = b.fornavn;
                            lastName = b.efternavn;
                                  
                        }catch(IllegalArgumentException e){
                            //System.out.println("\nWrong username or password..\n");
                        }
                        
                        
                    } 
                    else 
                    {
                        //serverTxtChat.append("No Conditions were met. \n");
                        //serverTxtChat2.append("No Conditions were met. \n");
                        System.out.println("No Conditions were met. \n");
                    }
                } 
             } 
             catch (Exception ex) 
             {
                //serverTxtChat.append("Lost a connection. \n");
                //serverTxtChat.append(data[2]);
                //System.out.println(data[2]);
                //ex.printStackTrace();
                 
                chatLogic.clientOutputStreams.remove(client);
             } 
	} 
    }
