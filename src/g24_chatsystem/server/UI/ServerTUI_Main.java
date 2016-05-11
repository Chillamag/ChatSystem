/*
 *  Chat System
 *  Lavet af Gruppe 24 - DTU 2016
 *  --------------------
 *  Bao Duy Nguyen, s144880
 *  Magnus Andrias Nielsen, s141899
 *  --------------------
 */
package g24_chatsystem.server.UI;

/**
 *
 * @author Magnus A. Nielsen
 */


import g24_chatsystem.server.jar.ChatUser;
import g24_chatsystem.server.ChatUserImpl;

public class ServerTUI_Main {
    
    public static void main(String[] args) throws Exception{
        ChatUser user = new ChatUserImpl();
        ServerUI ui = new ServerTUI(user);
        
        ui.start();
    }
    
}
