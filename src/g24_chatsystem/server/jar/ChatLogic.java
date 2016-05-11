/*
 *  Chat System
 *  Lavet af Gruppe 24 - DTU 2016
 *  --------------------
 *  Magnus Andrias Nielsen, s141899
 *  --------------------
 */
package g24_chatsystem.server.jar;

import static g24_chatsystem.server.ServerFrame.serverTxtChat2;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Magnus A. Nielsen
 */
public class ChatLogic {
    
    static ArrayList clientOutputStreams;
    static ArrayList<String> users;
    
    public void userAdd (String data){
        
        String message, add = ": :Connected", done = "Server: :Done", name = data;
        users.add(name);
        String[] tempList = new String[(users.size())];
        users.toArray(tempList);
    }
    
    public void userRemove (String data){
        String message, add = " is connected", done = "", name = data;
        users.remove(name);
        String[] tempList = new String[(users.size())];
        users.toArray(tempList);
    }
    
    public void tellEveryone(String message){
        Iterator it = clientOutputStreams.iterator();
        
        while (it.hasNext()){
            try{
                PrintWriter writer = (PrintWriter) it.next();
		writer.println(message);
		
                serverTxtChat2.append("" + message + "\n");
                System.out.println(message + "\n");
                writer.flush();
                
                serverTxtChat2.setCaretPosition(serverTxtChat2.getDocument().getLength());
                System.out.println(message + "\n");
                
                
            }catch (Exception ex){
                serverTxtChat2.append("Error telling everyone. \n");
                System.out.println("Error telling everyone. \n");
            }
        }
    }
    
}
