/*
 *  Chat System
 *  Lavet af Gruppe 24 - DTU 2016
 *  --------------------
 *  Bao Duy Nguyen, s144880
 *  Magnus Andrias Nielsen, s141899
 *  --------------------
 */
package g24_chatsystem.client;

import static g24_chatsystem.client.ClientFrame.reader;
import static g24_chatsystem.client.ClientFrame.txtChat;
import static g24_chatsystem.client.ClientFrame.userAdd;
import static g24_chatsystem.client.ClientFrame.userRemove;
import static g24_chatsystem.client.ClientFrame.users;
import static g24_chatsystem.client.ClientFrame.writeUsers;

/**
 *
 * @author Magnus A. Nielsen
 */
public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
            String[] data;
            String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat", login = "Login";

            try 
            {
                while ((stream = reader.readLine()) != null) 
                {
                     data = stream.split(":");

                     if (data[2].equals(chat)) 
                     {
                        txtChat.append(data[0] + ": " + data[1] + "\n");
                        txtChat.setCaretPosition(txtChat.getDocument().getLength());
                     } 
                     else if (data[2].equals(connect))
                     {
                        txtChat.removeAll();
                        userAdd(data[0]);
                     } 
                     else if (data[2].equals(disconnect)) 
                     {
                         userRemove(data[0]);
                     } 
                     else if (data[2].equals(login)) 
                     {
                         txtChat.append(data[0] + ": " + data[1] + "\n");
                     } 
                     else if (data[2].equals(done)) 
                     {
                        //users.setText("");
                        writeUsers();
                        users.clear();
                     }
                }
           }catch(Exception ex) { 
            //txtChat.append("Error in IncomingReader\n");
            //ex.printStackTrace();
           }
        }
    }
